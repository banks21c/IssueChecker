package com.goodbyenote.issuechecker.gcm.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodbyenote.issuechecker.gcm.service.DatastoreService;
import com.goodbyenote.issuechecker.gcm.util.ApiKeyInitializer;
import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

@Controller
public class GcmController {
	
	private static final Logger logger = LoggerFactory.getLogger(GcmController.class);
	
	static final String ATTRIBUTE_STATUS = "status";
	
	private static final int MULTICAST_SIZE = 1000;

	private Sender sender = null;

	private static final Executor threadPool = Executors.newFixedThreadPool(5);
	
	private static final String PARAMETER_REG_ID = "regId";
	
	static final boolean DEBUG = true;

	
    @Autowired
    private ServletContext context;
    
//    @Autowired
//    private ServletConfig config;
	
	@Autowired
	DatastoreService datastoreService;
	
	@RequestMapping("/gcm/home.do")
	public String home(Model model, @RequestParam Map parameterMap, HttpServletRequest request, HttpSession httpSession) throws Exception {
		
		String status = (String) request.getAttribute(ATTRIBUTE_STATUS);
		
		model.addAttribute("status", status);
		
		List<String> devices = datastoreService.getDevices();
		model.addAttribute("devices", devices);
		
		return "gcm/home"; 
	}	
		
	
	@RequestMapping("/gcm/sendAll.do")
	public String sendAll(Model model, @RequestParam Map parameterMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if ( sender == null ) {
			//sender = newSender(config);
		}
		
		List<String> devices = datastoreService.getDevices();
		String status;
		if (devices.isEmpty()) {
			status = "Message ignored as there is no device registered!";
		} else {
			// NOTE: check below is for demonstration purposes;
			// a real application
			// could always send a multicast, even for just one recipient
			if (devices.size() == 1) {
				// send a single message using plain post
				String registrationId = devices.get(0);
				Message message = new Message.Builder().build();
				Result result = sender.send(message, registrationId, 5);
				status = "Sent message to one device: " + result;
			} else {
				// send a multicast message using JSON
				// must split in chunks of 1000 devices (GCM limit)
				int total = devices.size();
				List<String> partialDevices = new ArrayList<String>(total);
				int counter = 0;
				int tasks = 0;
				for (String device : devices) {
					counter++;
					partialDevices.add(device);
					int partialSize = partialDevices.size();
					if (partialSize == MULTICAST_SIZE || counter == total) {
						asyncSend(partialDevices);
						partialDevices.clear();
						tasks++;
					}
				}
				status = "Asynchronously sending " + tasks + " multicast messages to " + total + " devices";
			}
		}

		request.setAttribute(ATTRIBUTE_STATUS, status.toString());		


		return "forward:/gcm/home.do";
	}	
		
	protected Sender newSender(ServletConfig config) {
		//String key = (String) config.getServletContext().getAttribute(ApiKeyInitializer.ATTRIBUTE_ACCESS_KEY);
		String key = ApiKeyInitializer.ATTRIBUTE_ACCESS_KEY;
		return new Sender(key);
	}
	
	private void asyncSend(List<String> partialDevices) {
		// make a copy
		final List<String> devices = new ArrayList<String>(partialDevices);
		threadPool.execute(new Runnable() {

			public void run() {
				Message message = new Message.Builder().build();
				MulticastResult multicastResult;
				try {
					multicastResult = sender.send(message, devices, 5);
				} catch (Exception e) {
					logger.error("Error posting messages", e);
					return;
				}
				List<Result> results = multicastResult.getResults();
				// analyze the results
				for (int i = 0; i < devices.size(); i++) {
					String regId = devices.get(i);
					Result result = results.get(i);
					String messageId = result.getMessageId();
					if (messageId != null) {
						logger.info("Succesfully sent message to device: " + regId +
								"; messageId = " + messageId);
						String canonicalRegId = result.getCanonicalRegistrationId();
						if (canonicalRegId != null) {
							// same device has more than on registration id: update it
							logger.info("canonicalRegId " + canonicalRegId);
							datastoreService.updateRegistration(regId, canonicalRegId);
						}
					} else {
						String error = result.getErrorCodeName();
						if (error.equals(Constants.ERROR_NOT_REGISTERED)) {
							// application has been removed from device - unregister it
							logger.info("Unregistered device: " + regId);
							datastoreService.unregister(regId);
						} else {
							logger.error("Error sending message to " + regId + ": " + error);
						}
					}
				}
			}
		});
	}
	
	@RequestMapping("/gcm/register.do")
	public void register(Model model, @RequestParam Map parameterMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String regId = getParameter(request, PARAMETER_REG_ID);
		if (isEmptyOrNull(regId) ){
			setError(response);
		} else {
			datastoreService.register(regId);
			setSuccess(response);
		}		
	}
	
	@RequestMapping("/gcm/unregister.do")
	public void unregister(Model model, @RequestParam Map parameterMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String regId = getParameter(request, PARAMETER_REG_ID);
		if(isEmptyOrNull(regId)){
			setError(response);
		} else {
			datastoreService.unregister(regId);
			setSuccess(response);
		}	
	}

	String getParameter(HttpServletRequest req, String parameter)	throws Exception {
		String value = req.getParameter(parameter);
		if (isEmptyOrNull(value)) {
			if (DEBUG) {
				StringBuilder parameters = new StringBuilder();
				@SuppressWarnings("unchecked")
				Enumeration<String> names = req.getParameterNames();
				while (names.hasMoreElements()) {
					String name = names.nextElement();
					String param = req.getParameter(name);
					parameters.append(name).append("=").append(param).append("\n");
				}
				logger.info("parameters: " + parameters);
			}
			throw new ServletException("Parameter " + parameter + " not found");
		}
		return value.trim();
	}

	protected String getParameter(HttpServletRequest req, String parameter,	String defaultValue) {
		String value = req.getParameter(parameter);
		if (isEmptyOrNull(value)) {
			value = defaultValue;
		}
		return value.trim();
	}

	protected void setSuccess(HttpServletResponse resp) {
		setSuccess(resp, 0);
	}

	protected void setSuccess(HttpServletResponse resp, int size) {
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("text/plain");
		resp.setContentLength(size);
	}
	
	protected void setError(HttpServletResponse resp){
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		resp.setContentType("text/plain");
		resp.setContentLength(0);
	}

	protected boolean isEmptyOrNull(String value) {
		return value == null || value.trim().length() == 0;
	}
}
