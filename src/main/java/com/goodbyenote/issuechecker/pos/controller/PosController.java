package com.goodbyenote.issuechecker.pos.controller;

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodbyenote.issuechecker.pos.model.MainVO;
import com.goodbyenote.issuechecker.pos.service.PosService;

@Controller
public class PosController {
	
	private static final Logger logger = LoggerFactory.getLogger(PosController.class);	
	
    @Autowired
    private ServletContext context;
    
//    @Autowired
//    private ServletConfig config;
	
	@Autowired
	PosService datastoreService;
	
	@RequestMapping(value = "/pos/list")
	public String list( MainVO main
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/list";
	}	
	
	@RequestMapping("/pos/insertTestData.do")
	public void insertTestData(Model model, 
			@RequestParam Map parameterMap, 
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		datastoreService.insertTestData();
		setSuccess(response);
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