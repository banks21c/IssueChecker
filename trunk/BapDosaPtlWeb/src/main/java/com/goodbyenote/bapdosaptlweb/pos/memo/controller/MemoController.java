package com.goodbyenote.bapdosaptlweb.pos.memo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodbyenote.bapdosaptlweb.pos.memo.service.MemoService;

@Controller
public class MemoController {
	private static final Logger logger = LoggerFactory.getLogger(MemoController.class);
	
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(value = "/pos/memo/customerRequest.do")
	public String customerRequest() {

		return "pos/memo/customerRequest";
	}		
}
