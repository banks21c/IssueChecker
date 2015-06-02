package com.goodbyenote.issuechecker.issue.controller;

import java.util.HashMap;
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

import com.goodbyenote.issuechecker.common.model.ReturnJsonVO;
import com.goodbyenote.issuechecker.issue.service.UserService;
import com.goodbyenote.issuechecker.member.controller.LoginController;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/issue/getLoginUser.do")
	public ModelAndView getLoginUser(HttpServletRequest request, HttpServletResponse response, Map param) throws Exception{
		if( logger.isDebugEnabled() ) {
			logger.debug(this.getClass().getName()+".getLoginUser start");
	        logger.debug(param.toString());
	    }
		
		Map<String, Object> model = new HashMap<String, Object>();
		Map listNotice = userService.getLoginUser(param);

		model.put("issueList", listNotice);
		model.put("searchVO", param);
		
		String rstUrl = "issue/issueList";
		return new ModelAndView(rstUrl, model);	
	
	}
	

}
