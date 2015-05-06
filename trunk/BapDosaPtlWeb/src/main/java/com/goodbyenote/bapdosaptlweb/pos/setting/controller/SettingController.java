package com.goodbyenote.bapdosaptlweb.pos.setting.controller;

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

import com.goodbyenote.bapdosaptlweb.common.model.ReturnJsonVO;
import com.goodbyenote.bapdosaptlweb.common.model.SessionUserInfo;
import com.goodbyenote.bapdosaptlweb.common.util.SecurityUtils;
import com.goodbyenote.bapdosaptlweb.pos.setting.service.SettingService;

@Controller
public class SettingController {
	private static final Logger logger = LoggerFactory.getLogger(SettingController.class);
	
	@Autowired
	private SettingService settingService;
	
	@RequestMapping(value = "/pos/setting/setCustomerRequest.json")
	public ModelAndView setCustomerRequest(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) {	
		
		int resultValue = 1;
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");

		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("deviceId", sessionUserInfo.getDeviceId());
		parametaMap.put("isdeleted", "N");
		
		String requestId = SecurityUtils.getTimeFormatUnique();
		parametaMap.put("requestId", requestId);
		settingService.setCustomerRequest(parametaMap);
			
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(requestId);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	@RequestMapping(value = "/pos/setting/getCustomerRequestList.json")
	public ModelAndView getCustomerRequestList(HttpSession httpSession) {

		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		Map parametaMap = new HashMap();
		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("isDeleted", "N");	
		List<Map> customerRequestList = settingService.getCustomerRequestList(parametaMap);
		
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(customerRequestList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
}