package com.goodbyenote.bapdosaptlweb.pos.special.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goodbyenote.bapdosaptlweb.common.model.ReturnJsonVO;
import com.goodbyenote.bapdosaptlweb.common.model.SessionUserInfo;
import com.goodbyenote.bapdosaptlweb.pos.special.service.SpecialService;


@Controller
public class SpecialController {
private static final Logger logger = LoggerFactory.getLogger(SpecialController.class);
	
	@Autowired
	private SpecialService specialService;
	
	@RequestMapping(value = "/pos/special/tableMove.do")
	public String tableMove() {

		return "pos/special/tableMove";
	}		
	
	///pos/sepcial/tableMoveOk.json
	@RequestMapping(value = "/pos/sepcial/tableMoveOk.json")
	public ModelAndView tableMoveOk(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) throws JsonParseException, JsonMappingException, IOException {	
		
		int resultValue = 1;
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");

		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		
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
}
