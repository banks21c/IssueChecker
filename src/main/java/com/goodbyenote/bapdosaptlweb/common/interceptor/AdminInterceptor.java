package com.goodbyenote.bapdosaptlweb.common.interceptor;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.goodbyenote.bapdosaptlweb.common.model.SessionAdminInfo;


public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
	
	private String excludePath = "/admin/login";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession(false);
		String requestURL = request.getRequestURI();
		
		logger.debug("requestURL: " + requestURL);
		
		boolean result = true;	
		
		if(!isSessionTransparent(requestURL)){
			
			//log.debug("requestURL: " + requestURL);
		
			if(session != null){
				SessionAdminInfo sessionAdminInfo = (SessionAdminInfo)session.getAttribute("SESSION_ADMIN_INFO");
				
				if(sessionAdminInfo != null){
					
					if(sessionAdminInfo.getId() == null || "".equalsIgnoreCase(sessionAdminInfo.getId())){
						response.sendRedirect(request.getContextPath()+"/admin/login.do");
						result = false;
					}
					
					
				} else {
			
					response.sendRedirect(request.getContextPath()+"/admin/login.do");
					result = false;
					
				}
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/login.do");
				result = false;
			}
		}		
		
		
		return result;
	}
	
	private boolean isSessionTransparent(String requestUrl) {
		boolean isSkip = false;
		StringTokenizer st = new StringTokenizer(excludePath, ";");
		while (st.hasMoreElements()) {
			String excludeAction = (String) st.nextElement();
			if (requestUrl.indexOf(excludeAction) > -1) {
				isSkip = !isSkip;
				break;
			}
		}
		
		logger.debug("isSkip: " + isSkip);

		return isSkip;
	}	

}
