package com.goodbyenote.issuechecker.pos.customer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goodbyenote.issuechecker.common.model.ReturnJsonVO;
import com.goodbyenote.issuechecker.common.model.SessionUserInfo;
import com.goodbyenote.issuechecker.common.util.SecurityUtils;
import com.goodbyenote.issuechecker.pos.customer.service.CustomerService;


@Controller
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/pos/customer/customerRegister.json", method = RequestMethod.POST)
	public ModelAndView customerRegister(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) {	
		
		int resultValue = 1;
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		//logger.debug(parametaMap.toString());
		
		//String orderObjJson = (String)parametaMap.get("orderObjJson");		
		
		//logger.debug(orderObjJson);
		
		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("deviceId", sessionUserInfo.getDeviceId());
		parametaMap.put("customerId", SecurityUtils.getTimeFormatUnique());
		customerService.insertCustomer(parametaMap);
			
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(parametaMap.get("customerId"));
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	@RequestMapping(value = "/pos/customer/getCustomerInfo.json")
	public ModelAndView getCustomerInfo(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) {	
		
		int resultValue = 1;
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");

		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("isdeleted", "N");
		Map customerInfoMap = customerService.getCustomer(parametaMap);
			
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(customerInfoMap);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	@RequestMapping(value = "/pos/customer/getCustomerList.json")
	public ModelAndView getCustomerList(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) {	
		
		int resultValue = 1;
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");

		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("isdeleted", "N");
		
		System.out.println(parametaMap);
		
		List<Map> customerMapList = customerService.getCustomerList(parametaMap);
		int totalCount = customerService.getCustomerListCount(parametaMap);
		
		Map returnObj = new HashMap();
		returnObj.put("totalCount", totalCount);
		returnObj.put("customerMapList", customerMapList);
			
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(returnObj);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
}
