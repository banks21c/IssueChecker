package com.goodbyenote.issuechecker.issue.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goodbyenote.issuechecker.common.model.GlobalStatic;
import com.goodbyenote.issuechecker.common.model.ReturnJsonVO;
import com.goodbyenote.issuechecker.common.model.SessionUserInfo;
import com.goodbyenote.issuechecker.common.util.DateUtil;
import com.goodbyenote.issuechecker.common.util.SecurityUtils;
import com.goodbyenote.issuechecker.issue.service.IssueService;
import com.goodbyenote.issuechecker.issue.vo.IssueVO;
import com.goodbyenote.issuechecker.member.controller.LoginController;

@Controller
public class IssueController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	IssueService issueService;
	
	@RequestMapping("/issue/test.do")
	public String issueList(Model model) {
		
		return "/issue/issueList";
	}	
	
	
	@RequestMapping("/issue/sample.json")
	public ModelAndView sample(Model model, @RequestParam(required=true) Map parametaMap, HttpSession httpSession){
		logger.debug(parametaMap.toString());
		
		String returnCode = "1";// 0: error, 1: 성공
		int returnVal = 0;
		String message = "해당 사업자번호가 등록되지 않았습니다.";
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode(returnCode);// 0: error, 1: 성공
		returnJsonVO.setMessage(message);
		returnJsonVO.setReturnObj(returnVal);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@RequestMapping("/issue/issueList.do")
	public ModelAndView issueList(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = true) Map param) throws Exception {
		if( logger.isDebugEnabled() ) {
			logger.debug(this.getClass().getName()+".issueList start");
	        logger.debug(param.toString());
	    }
		//type
		//0:요건, 1:버그, 2: 요청
		String type = request.getParameter("type");
		//state
		//0:open, 1:close, 2: suspend, 3: solved
		String state = request.getParameter("state");
		logger.debug("type:"+type);
		logger.debug("state:"+state);
		String viewAll = request.getParameter("viewAll");
		logger.debug("viewAll:"+viewAll);
		
		
		Map<String, Object> model = new HashMap<String, Object>();
		List<Map> issueList = issueService.getIssueList(param);
		model.put("issueList", issueList);

		List<Map> chargePersonList = issueService.getChargePersonList();
		model.put("chargePersonList", chargePersonList);
		
		HttpSession session = request.getSession(true);
		SessionUserInfo sessionUserInfo = (SessionUserInfo)session.getAttribute("SESSION_USER_INFO");
		
		if(sessionUserInfo != null){			
			model.put("registerId", sessionUserInfo.getUserId());				
		}
		
		model.put("searchVO", param);
		
		String rstUrl = "issue/issueList";
		return new ModelAndView(rstUrl, model);	
	
	}
	
	@RequestMapping("/issue/issueDetail.do")
//	public ModelAndView issueDetail(HttpServletRequest request, HttpServletResponse response, Map param) throws Exception{
	public ModelAndView issueDetail(@RequestParam(required=true) Map param
			,HttpSession httpSession) throws Exception{
		if( logger.isDebugEnabled() ) {
			logger.debug(this.getClass().getName()+".issueDetail start");
	        logger.debug(param.toString());
	    }
		//String issueId = request.getParameter("issueId");
		//logger.debug("issueId:"+issueId);
		
		Map<String, Object> model = new HashMap<String, Object>();
		//param.put("issueId", issueId);
		Map issueDetail = issueService.getIssueDetail(param);

		model.put("issueDetail", issueDetail);

		List<Map> chargePersonList = issueService.getChargePersonList();
		model.put("chargePersonList", chargePersonList);

		model.put("searchParamMap", param);
		
		String rstUrl = "issue/issueDetail";
		return new ModelAndView(rstUrl, model);	
	
	}
	
	@RequestMapping("/issue/modifyIssue.do")
	public ModelAndView modifyIssue(@RequestParam(required=true) Map param
			,HttpSession httpSession) throws Exception{
		if( logger.isDebugEnabled() ) {
			logger.debug(this.getClass().getName()+".modifyIssue start");
	        logger.debug(param.toString());
	    }
		//String issueId = request.getParameter("issueId");
		//logger.debug("issueId:"+issueId);
		
		Map<String, Object> model = new HashMap<String, Object>();
		//param.put("issueId", issueId);
		Map issueDetail = issueService.getIssueDetail(param);

		model.put("issueDetail", issueDetail);

		List<Map> chargePersonList = issueService.getChargePersonList();
		model.put("chargePersonList", chargePersonList);

		model.put("searchParamMap", param);
		
		String rstUrl = "issue/issueModify";
		return new ModelAndView(rstUrl, model);	
	
	}
	
	
	
	@RequestMapping(value = "/issue/saveIssue.do")
	public ModelAndView saveIssue(
			@RequestParam(required=true) Map param
			,HttpSession httpSession,HttpServletRequest request) {	
		
		logger.debug(this.getClass().getName()+".param:"+param);
		
		String issueId = (String) param.get("issueId");
		HttpSession session = request.getSession(true);
		SessionUserInfo sessionUserInfo = (SessionUserInfo)session.getAttribute("SESSION_USER_INFO");
		
		if(sessionUserInfo != null){			
			param.put("registerId", sessionUserInfo.getUserId());				
		}
		
		int resultValue = issueService.saveIssue(param);

		String returnCode = "0";
		if(resultValue > 0) returnCode = "1";
		String message = "";
		String returnVal = "";
			
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("issueId", issueId);
		model.put("resultValue", resultValue);
		model.put("searchParamMap", param);
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode(returnCode);// 0: error, 1: 성공
		returnJsonVO.setMessage(message);
		returnJsonVO.setReturnObj(returnVal);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
		
	}	
	
	@RequestMapping("/issue/saveIssue.json")
	public ModelAndView saveIssue(Model model,
			@RequestParam(required = true) Map param,
			HttpSession httpSession, HttpServletRequest request) {

		logger.debug(param.toString());
		
		HttpSession session = request.getSession(true);
		SessionUserInfo sessionUserInfo = (SessionUserInfo)session.getAttribute("SESSION_USER_INFO");
		
		if(sessionUserInfo != null){			
			param.put("registerId", sessionUserInfo.getUserId());				
		}
		
		String issueId = (String) param.get("issueId");
		if(issueId != null){
			param.put("eventType", "1");//수정
			param.put("crud", "u");
		}else{
			param.put("eventType", "0");//등록				
			param.put("crud", "c");

			issueId = issueService.getIssueId();
			param.put("issueId", issueId);
		}
		
		String currentChagePersonId = (String)param.get("currentChargePersonId");
		String chargePersonId = (String)param.get("chargePersonId");
		
		logger.debug("currentChagePersonId:"+currentChagePersonId);
		logger.debug("chargePersonId:"+chargePersonId);
		logger.debug("is same:"+currentChagePersonId.equals(chargePersonId));
		logger.debug("is not same:"+!currentChagePersonId.equals(chargePersonId));

		int resultValue = issueService.saveIssue(param);
		logger.debug("resultValue:"+resultValue);
		if(resultValue > 0){
			int saveResult = issueService.saveIssueEventHistory(param);
			if(saveResult > 0){
                if(!chargePersonId.equals(currentChagePersonId)){
                        param.put("eventType", "4");//담당자지정
                        logger.debug("param:"+param.toString());
                        logger.debug("eventType:"+param.get("eventType"));
                        issueService.saveIssueEventHistory(param);
                }
			}
		}		
		
		String returnCode = resultValue +"";
		int returnVal = 0;
		String message = "";
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode(returnCode);// 0: error, 1: 성공
		returnJsonVO.setMessage(message);
		returnJsonVO.setReturnObj(returnVal);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}

	@RequestMapping("/issue/deleteIssue.json")
	public ModelAndView deleteIssue(Model model,
			@RequestParam(required = true) Map param,
			HttpSession httpSession, HttpServletRequest request) {

		logger.debug(param.toString());
		
		HttpSession session = request.getSession(true);
		SessionUserInfo sessionUserInfo = (SessionUserInfo)session.getAttribute("SESSION_USER_INFO");
		
		if(sessionUserInfo != null){			
			param.put("registerId", sessionUserInfo.getUserId());				
		}
		
        param.put("eventType", "2");//삭제
		
		
		int resultValue = issueService.deleteIssue(param);
		if(resultValue > 0){
			issueService.saveIssueEventHistory(param);
		}
		
		String returnCode = resultValue +"";
		int returnVal = 0;
		String message = "";
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode(returnCode);// 0: error, 1: 성공
		returnJsonVO.setMessage(message);
		returnJsonVO.setReturnObj(returnVal);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@RequestMapping("/issue/insertUserIssueCheck.json")
	public ModelAndView insertUserIssueCheck(Model model,
			@RequestParam(required = true) Map param,
			HttpSession httpSession, HttpServletRequest request) {

		logger.debug(param.toString());
		
		HttpSession session = request.getSession(true);
		SessionUserInfo sessionUserInfo = (SessionUserInfo)session.getAttribute("SESSION_USER_INFO");
		
		if(sessionUserInfo != null){			
			param.put("userId", sessionUserInfo.getUserId());				
		}
		
		int resultValue = issueService.insertUserIssueCheck(param);
		
		String returnCode = resultValue +"";
		int returnVal = 0;
		String message = "";
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode(returnCode);// 0: error, 1: 성공
		returnJsonVO.setMessage(message);
		returnJsonVO.setReturnObj(returnVal);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@RequestMapping(value = "/issue/issueRegist.do")
	public ModelAndView issueRegist(
			@RequestParam(required=true) Map param
			,HttpSession httpSession) {	
		
		logger.debug(this.getClass().getName()+".param:"+param);

			
		Map<String, Object> model = new HashMap<String, Object>();
		
		List<Map> chargePersonList = issueService.getChargePersonList();
		model.put("chargePersonList", chargePersonList);
		
		String rstUrl = "/issue/issueRegist";
		return new ModelAndView(rstUrl, model);	
	}	
	
}
