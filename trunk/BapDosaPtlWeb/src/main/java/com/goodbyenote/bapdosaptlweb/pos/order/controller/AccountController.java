package com.goodbyenote.bapdosaptlweb.pos.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodbyenote.bapdosaptlweb.pos.order.service.AccountService;


@Controller
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/pos/order/account.do")
	public String account() {

		return "pos/order/account";
	}		
}
