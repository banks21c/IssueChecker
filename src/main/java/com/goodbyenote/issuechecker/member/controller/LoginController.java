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
import com.goodbyenote.issuechecker.member.service.MemberService;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/login/login.do")
	public String login(Model model) {
		
		return "/login/login";
	}	
	
	
	//loginOk.json
	@RequestMapping("/login/loginOk.json")
	public ModelAndView loginOk(Model model, @RequestParam(required=true) Map parametaMap, HttpSession httpSession){
		logger.debug(parametaMap.toString());
		
		String returnCode = "1";// 0: error, 1: 성공
		String businessNumber = (String)parametaMap.get("businessNumber");
		
		Map userMapTemp = memberService.getMemberByBusinessNumber(parametaMap);
		System.out.println(userMapTemp);
		int returnVal = 0;
		String message = "해당 사업자번호가 등록되지 않았습니다.";
		
		SessionUserInfo sessionUserInfo = new SessionUserInfo();
		if(userMapTemp != null && userMapTemp.get("BUSINESSNUMBER") != null && !"".equals(userMapTemp.get("BUSINESSNUMBER"))){
			returnVal = 1;
			message = "ok";
			
			if("Y".equals((String)userMapTemp.get("ISDELETED"))){
				returnVal = 0;
				message = "사용중지된 사업자 번호입니다.";	//"사용중지된 메일 아이디 입니다.";				

			} else {

				sessionUserInfo.setMemberId( userMapTemp.get("MEMBERID").toString());
				sessionUserInfo.setBusinessnumber((String)userMapTemp.get("BUSINESSNUMBER"));
				sessionUserInfo.setPhonenumber((String)userMapTemp.get("PHONENUMBER"));
				sessionUserInfo.setMembername((String)userMapTemp.get("MEMBERNAME"));
				sessionUserInfo.setPhonenumber2((String)userMapTemp.get("PHONENUMBER2"));
				sessionUserInfo.setMembertype((String)userMapTemp.get("MEMBERTYPE"));
				sessionUserInfo.setDeviceId(userMapTemp.get("DEVICEID").toString());
				
				Map environmentMap = new HashMap();
				environmentMap.put("isPriceDeviced", "Y");
				sessionUserInfo.setEnvironmentMap(environmentMap);
				
				
				System.out.println("sessionUserInfo:" + sessionUserInfo);
					
				//세션 생성
				httpSession.setAttribute("SESSION_USER_INFO", sessionUserInfo);					
			}
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
