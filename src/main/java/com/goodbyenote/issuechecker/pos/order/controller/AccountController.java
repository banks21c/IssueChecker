package com.goodbyenote.issuechecker.pos.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goodbyenote.issuechecker.common.model.ReturnJsonVO;
import com.goodbyenote.issuechecker.common.model.SessionUserInfo;
import com.goodbyenote.issuechecker.pos.order.service.AccountService;
import com.goodbyenote.issuechecker.pos.order.service.OrderService;


@Controller
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private OrderService orderService;	
	
	@RequestMapping(value = "/pos/order/account.do")
	public String account() {

		return "pos/order/account";
	}	
	
	
	
	@RequestMapping(value = "/pos/account/setAccountComplete.json")	
	public ModelAndView setAccountComplete(HttpSession httpSession, @RequestParam(required=true) Map parametaMap) {
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("deviceId", sessionUserInfo.getDeviceId());
		parametaMap.put("ispaid", "Y");
		
		orderService.setAccountComplete(parametaMap);		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setReturnObj("1");
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}		
}
