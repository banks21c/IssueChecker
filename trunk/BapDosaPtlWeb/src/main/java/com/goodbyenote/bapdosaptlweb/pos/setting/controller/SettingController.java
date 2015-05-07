package com.goodbyenote.bapdosaptlweb.pos.setting.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goodbyenote.bapdosaptlweb.common.model.ReturnJsonVO;
import com.goodbyenote.bapdosaptlweb.common.model.SessionUserInfo;
import com.goodbyenote.bapdosaptlweb.common.util.SecurityUtils;
import com.goodbyenote.bapdosaptlweb.pos.order.service.OrderService;
import com.goodbyenote.bapdosaptlweb.pos.setting.service.SettingService;

@Controller
public class SettingController {
	private static final Logger logger = LoggerFactory.getLogger(SettingController.class);
	
	@Autowired
	private SettingService settingService;
	
	@Autowired
	private OrderService orderService;
	
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pos/setting/getCustomerRequestList.json")
	public ModelAndView getCustomerRequestList(@RequestParam Map parametaMap, Model model, HttpServletRequest request , HttpSession httpSession) {

		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("isDeleted", "N");	
		List<Map> customerRequestList = settingService.getCustomerRequestList(parametaMap);
		
		
		Map returnMap = new HashMap();
		returnMap.put("customerRequestList", customerRequestList);
		
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(returnMap);
		logger.debug("returnMap: " + returnMap);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	@RequestMapping(value = "/pos/setting/setting.do")
	public String settingList(HttpSession httpSession) {	

		return "pos/setting/setting";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/pos/setting/getOrderTableList.json")	
	public ModelAndView getOrderTableList( @RequestParam Map parametaMap, Model model, HttpServletRequest request ,HttpSession httpSession) {
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("isDeleted", "N");
		parametaMap.put("orderBy", "A.TABLEID");
		parametaMap.put("orderOption", "ASC");
		
		List<Map> orderMapList = orderService.getOrderTablePresentList(parametaMap);
		
		Map returnMap = new HashMap();
		returnMap.put("orderMapList", orderMapList);
		returnMap.put("isPriceDiffer", "N");
		returnMap.put("isDPdiffer", "N");
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setReturnObj(returnMap);
		logger.debug("returnMap: " + returnMap);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
	
		
		return mav; 
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pos/setting/getPointDcList.json")
	public ModelAndView getPointDcList(@RequestParam Map parametaMap, Model model, HttpServletRequest request , HttpSession httpSession) {

		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		List<Map> pointDcList = settingService.getPointDcList(parametaMap);
		
		
		Map returnMap = new HashMap();
		returnMap.put("pointDcList", pointDcList);
		
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(returnMap);
		logger.debug("returnMap: " + returnMap);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/setting/tableUpdatetOk.json")
	public ModelAndView tableUpdatetOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		logger.debug(parametaMap.toString());
		String tableno = (String)parametaMap.get("tableno");
		String isdeleted = (String)parametaMap.get("isdeleted");
		String totalcount = (String)parametaMap.get("totalCount");
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		parametaMap.put("tableno", tableno);
		parametaMap.put("isdeleted", isdeleted);
		
		if(Integer.parseInt(totalcount) > Integer.parseInt(tableno)){		
		   settingService.updateTableCount(parametaMap);
		}else{
			settingService.updateTableCount2(parametaMap);
		}
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/setting/dcUpdatetOk.json")
	public ModelAndView dcUpdatetOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		logger.debug(parametaMap.toString());
		String settingid = (String)parametaMap.get("settingid");
		String settingkey = (String)parametaMap.get("settingkey");
		String settingvalue = (String)parametaMap.get("settingvalue");
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		parametaMap.put("settingid", settingid);
		parametaMap.put("settingkey", settingkey);
		parametaMap.put("settingvalue", settingvalue);
				
		settingService.updateDcAmount(parametaMap);
		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/setting/requestUpdatetOk.json")
	public ModelAndView requestUpdatetOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		logger.debug(parametaMap.toString());
		String requestid = (String)parametaMap.get("requestid");
		String contents = (String)parametaMap.get("contents");
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		parametaMap.put("requestid", requestid);
		parametaMap.put("contents", contents);
		
				
		settingService.updateCustomerRequest(parametaMap);
		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
}
