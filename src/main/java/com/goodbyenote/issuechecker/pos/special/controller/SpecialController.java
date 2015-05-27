package com.goodbyenote.issuechecker.pos.special.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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
import com.goodbyenote.issuechecker.pos.special.service.SpecialService;


@Controller
public class SpecialController {
private static final Logger logger = LoggerFactory.getLogger(SpecialController.class);
	
	@Autowired
	private SpecialService specialService;
	
	@RequestMapping(value = "/pos/special/tableMove.do")
	public String tableMove() {

		return "pos/special/tableMove";
	}		
	
	@RequestMapping(value = "/pos/sepcial/tableMoveOk.json")
	public ModelAndView tableMoveOk(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) throws JsonParseException, JsonMappingException, IOException {	
		
		int resultValue = 1;
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");

		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("deviceId", sessionUserInfo.getDeviceId());
		
		specialService.setTableMove(parametaMap);
			
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(resultValue);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	@RequestMapping(value = "/pos/special/tableShare.do")
	public String tableShare() {

		return "pos/special/tableShare";
	}
	
	@RequestMapping(value = "/pos/sepcial/tableShareOk.json")
	public ModelAndView tableShareOk(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) {	
		
		int resultValue = 1;
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");

		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("deviceId", sessionUserInfo.getDeviceId());
		
		specialService.setTableShare(parametaMap);
			
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(resultValue);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	
	@RequestMapping(value = "/pos/sepcial/tableShareDelOk.json")
	public ModelAndView tableShareDelOk(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) {	
		
		int resultValue = 1;
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");

		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		
		resultValue = specialService.setTableShareDelOk(parametaMap);
			
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(resultValue);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	@RequestMapping(value = "/pos/special/tableConnect.do")
	public String tableConnect() {

		return "pos/special/tableConnect";
	}
	@RequestMapping(value = "/pos/special/tableNameChange.do")
	public String tableNameChange() {

		return "pos/special/tableNameChange";
	}	
	
	@RequestMapping(value = "/pos/sepcial/tableConnectOk.json")
	public ModelAndView tableConnectOk(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) throws JsonParseException, JsonMappingException, IOException {	
		
		int resultValue = 1;
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		String connectTableInfo = (String)parametaMap.get("connectTableInfo");		
		
		logger.debug(connectTableInfo);
		Map<String, Object> connectTableInfoMap = new ObjectMapper().readValue(connectTableInfo, HashMap.class) ;		

		connectTableInfoMap.put("memberId", sessionUserInfo.getMemberId());
		connectTableInfoMap.put("deviceId", sessionUserInfo.getDeviceId());		
		specialService.setTableConnect(connectTableInfoMap);
			
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(resultValue);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	@RequestMapping(value = "/pos/sepcial/tableConnectCancelOk.json")
	public ModelAndView tableConnectCancelOk(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) {	
		
		int resultValue = 1;
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");

		parametaMap.put("memberId", sessionUserInfo.getMemberId());		
		specialService.setTableConnectCancel(parametaMap);
			
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(resultValue);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/special/tableNameUpdateOk.json")
	public ModelAndView tableNameUpdateOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		logger.debug(parametaMap.toString());
		String tableNo = (String)parametaMap.get("tableNo");
		String tableName = (String)parametaMap.get("tableName");
		String tableId = (String)parametaMap.get("tableId");
		
		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("deviceId", sessionUserInfo.getDeviceId());
		parametaMap.put("tableNo", tableNo);
		parametaMap.put("tableName", tableName);
		parametaMap.put("tableId", tableId);		
				
		specialService.updateOrderTable(parametaMap);		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@RequestMapping(value = "/pos/special/ticketSale.do")
	public String ticketSale() {

		return "pos/special/ticketSale";
	}
}
