package com.goodbyenote.bapdosaptlweb.common.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.goodbyenote.bapdosaptlweb.common.exception.RequriedLoginException;
import com.goodbyenote.bapdosaptlweb.common.model.SessionUserInfo;
import com.goodbyenote.bapdosaptlweb.common.service.CommonService;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	
	@Autowired
	CommonService commonService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		logger.debug("LoginCheckInterceptor .. preHandle....");
		
		HttpSession session = request.getSession(true);
		
		boolean result = true;	
			
		if(session != null){
			SessionUserInfo sessionUserInfo = (SessionUserInfo)session.getAttribute("SESSION_USER_INFO");
			
			if(sessionUserInfo != null){			
				//paramMap.put("userId", sessionUserInfo.getUserId());				
			} else {
				throw new RequriedLoginException("로그인이 필요합니다.");	//"로그인이 필요합니다."
			}
		} else {
			throw new RequriedLoginException("로그인이 필요합니다.");	//"로그인이 필요합니다."
		}	
		
		return result;
	}
}
