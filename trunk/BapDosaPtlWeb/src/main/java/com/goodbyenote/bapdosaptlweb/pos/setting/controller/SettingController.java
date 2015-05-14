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
	@RequestMapping(value = "/pos/setting/getLunchTimeList.json")
	public ModelAndView getLunchTimeList(@RequestParam Map parametaMap, Model model, HttpServletRequest request , HttpSession httpSession) {

		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		List<Map> lunchTimeList = settingService.getLunchTimeList(parametaMap);		
		
		Map returnMap = new HashMap();
		returnMap.put("lunchTimeList", lunchTimeList);
		
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pos/setting/getRankList.json")
	public ModelAndView getRankList(@RequestParam Map parametaMap, Model model, HttpServletRequest request , HttpSession httpSession) {

		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		List<Map> rankList = settingService.getRankList(parametaMap);		
		
		Map returnMap = new HashMap();
		returnMap.put("rankList", rankList);
		
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pos/setting/getRankList2.json")
	public ModelAndView getRankList2(@RequestParam Map parametaMap, Model model, HttpServletRequest request , HttpSession httpSession) {

		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		List<Map> rankList2 = settingService.getRankList2(parametaMap);		
		
		Map returnMap = new HashMap();
		returnMap.put("rankList2", rankList2);
		
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
	@RequestMapping("/pos/setting/tableUpdateOk.json")
	public ModelAndView tableUpdateOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
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
	@RequestMapping("/pos/setting/lunchEqualUpdateOk.json")
	public ModelAndView lunchEqualUpdatetOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		logger.debug(parametaMap.toString());
		String timezonedivision = (String)parametaMap.get("timezonedivision");
		String isdifferenttime = (String)parametaMap.get("isdifferenttime");
		String starttime1 = (String)parametaMap.get("starttime1");
		String starttime2 = (String)parametaMap.get("starttime2");
		String starttime3 = (String)parametaMap.get("starttime3");
		String starttime4 = (String)parametaMap.get("starttime4");
		String starttime5 = (String)parametaMap.get("starttime5");
		String starttime6 = (String)parametaMap.get("starttime6");
		String starttime7 = (String)parametaMap.get("starttime7");
		
		String endtime1 = (String)parametaMap.get("endtime1");
		String endtime2 = (String)parametaMap.get("endtime2");
		String endtime3 = (String)parametaMap.get("endtime3");
		String endtime4 = (String)parametaMap.get("endtime4");
		String endtime5 = (String)parametaMap.get("endtime5");
		String endtime6 = (String)parametaMap.get("endtime6");
		String endtime7 = (String)parametaMap.get("endtime7");
		
		String isusedtime1 = (String)parametaMap.get("isusedtime1");
		String isusedtime2 = (String)parametaMap.get("isusedtime2");
		String isusedtime3 = (String)parametaMap.get("isusedtime3");
		String isusedtime4 = (String)parametaMap.get("isusedtime4");
		String isusedtime5 = (String)parametaMap.get("isusedtime5");
		String isusedtime6 = (String)parametaMap.get("isusedtime6");
		String isusedtime7 = (String)parametaMap.get("isusedtime7");
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("timezonedivision", timezonedivision);
		parametaMap.put("isdifferenttime", isdifferenttime);
		parametaMap.put("starttime1", starttime1);
		parametaMap.put("starttime2", starttime2);
		parametaMap.put("starttime3", starttime3);
		parametaMap.put("starttime4", starttime4);
		parametaMap.put("starttime5", starttime5);
		parametaMap.put("starttime6", starttime6);
		parametaMap.put("starttime7", starttime7);
		
		parametaMap.put("endtime1", endtime1);
		parametaMap.put("endtime2", endtime2);
		parametaMap.put("endtime3", endtime3);
		parametaMap.put("endtime4", endtime4);
		parametaMap.put("endtime5", endtime5);
		parametaMap.put("endtime6", endtime6);
		parametaMap.put("endtime7", endtime7);
		
		parametaMap.put("isusedtime1", isusedtime1);
		parametaMap.put("isusedtime2", isusedtime2);
		parametaMap.put("isusedtime3", isusedtime3);
		parametaMap.put("isusedtime4", isusedtime4);
		parametaMap.put("isusedtime5", isusedtime5);
		parametaMap.put("isusedtime6", isusedtime6);
		parametaMap.put("isusedtime7", isusedtime7);
				
		settingService.updateLunchEqual(parametaMap);
		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/setting/dcUpdateOk.json")
	public ModelAndView dcUpdateOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
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
	@RequestMapping("/pos/setting/rankUpdateOk.json")
	public ModelAndView rankUpdateOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		logger.debug(parametaMap.toString());
		String settingkey = (String)parametaMap.get("settingkey");
		String settingvalue = (String)parametaMap.get("settingvalue");
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		parametaMap.put("settingkey", settingkey);
		parametaMap.put("settingvalue", settingvalue);
				
		settingService.updateRank(parametaMap);
		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/setting/requestUpdateOk.json")
	public ModelAndView requestUpdateOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
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
