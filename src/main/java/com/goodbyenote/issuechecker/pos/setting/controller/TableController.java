package com.goodbyenote.issuechecker.pos.setting.controller;

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
import com.goodbyenote.issuechecker.pos.setting.service.TableService;

@Controller
public class TableController {
	private static final Logger logger = LoggerFactory.getLogger(TableController.class);
	
	@Autowired
	private TableService tableService;
	
	@RequestMapping(value = "/pos/setting/getTableInfo.json")
	public ModelAndView getCustomerInfo(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) {	
		
		int resultValue = 1;
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");

		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("isdeleted", "N");
		Map tableInfoMap = tableService.getOrderTable(parametaMap);
			
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(tableInfoMap);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
}
