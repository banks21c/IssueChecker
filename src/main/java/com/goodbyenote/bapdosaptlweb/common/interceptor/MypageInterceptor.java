package com.goodbyenote.bapdosaptlweb.common.interceptor;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.goodbyenote.bapdosaptlweb.common.model.SessionUserInfo;

public class MypageInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(MypageInterceptor.class);
	
	private String excludePath = "/mypage/secessionOk";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		String requestURL = request.getRequestURI();
		
		logger.debug("requestURL: " + requestURL);
		
		boolean result = true;	
		
		if(!isSessionTransparent(requestURL)){
			
			if(session != null){
				SessionUserInfo sessionUserInfo = (SessionUserInfo)session.getAttribute("SESSION_USER_INFO");
				
				if(sessionUserInfo == null){			
					response.sendRedirect(request.getContextPath()+"/login/login.do");
					result = false;				
				}
			} else {
				response.sendRedirect(request.getContextPath()+"/login/login.do");
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
