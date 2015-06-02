package com.goodbyenote.issuechecker.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goodbyenote.issuechecker.common.model.ReturnJsonVO;
import com.goodbyenote.issuechecker.common.model.SessionUserInfo;
import com.goodbyenote.issuechecker.issue.service.UserService;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/login/login.do")
	public String login(Model model) {
		
		return "/login/login";
	}	
	
	
	//login.json
	@RequestMapping("/login/login.json")
	public ModelAndView login(Model model, @RequestParam(required=true) Map<?, ?> paramMap, HttpSession httpSession){
		logger.debug(paramMap.toString());
		
		String returnCode = "1";// 0: error, 1: 성공
		String loginId = (String)paramMap.get("loginId");
		System.out.println("loginId:"+loginId);
		
		Map<?, ?> userMapTemp = userService.getLoginUser(paramMap);
		System.out.println("userMapTemp:"+userMapTemp);
		int returnVal = 0;
		String message = "로그인ID가 없습니다.";
		
		SessionUserInfo sessionUserInfo = new SessionUserInfo();
		if(userMapTemp != null && userMapTemp.get("USERID") != null && !"".equals(userMapTemp.get("USERID"))){
			returnVal = 1;
			message = "ok";

			sessionUserInfo.setUserId(userMapTemp.get("USERID").toString());
			sessionUserInfo.setLoginId((String) userMapTemp.get("LOGINID"));
			sessionUserInfo.setUserName((String) userMapTemp.get("USERNAME"));
			sessionUserInfo.setEmail((String) userMapTemp.get("EMAIL"));

			// 세션 생성
			httpSession.setAttribute("SESSION_USER_INFO", sessionUserInfo);			

		}	
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode(returnCode);// 0: error, 1: 성공
		returnJsonVO.setMessage(message);
		returnJsonVO.setReturnObj(returnVal);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}	
	
	@RequestMapping("/login/logout.do")
	public String logout( HttpSession httpSession) {
		
		if(httpSession != null){
			httpSession.removeAttribute("SESSION_USER_INFO");
		}
		
		return "redirect:/login/login.do";
	}	
	
	@RequestMapping("/login/logout.json")
	public ModelAndView logout( Model model, HttpSession httpSession) {
		
		String returnCode = "1";
		String returnVal = "1";
		
		if(httpSession != null){
			httpSession.removeAttribute("SESSION_USER_INFO");
		}
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode(returnCode);// 0: error, 1: 성공
		returnJsonVO.setMessage("logout ok..");
		returnJsonVO.setReturnObj(returnVal);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}		
	
}
