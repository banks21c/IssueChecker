package com.goodbyenote.bapdosaptlweb.pos.order.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.common.model.SessionUserInfo;
import com.goodbyenote.bapdosaptlweb.common.util.DateUtil;
import com.goodbyenote.bapdosaptlweb.common.util.SecurityUtils;
import com.goodbyenote.bapdosaptlweb.pos.order.dao.AccountDAO;
import com.goodbyenote.bapdosaptlweb.pos.order.dao.OrderDAO;
import com.goodbyenote.bapdosaptlweb.pos.order.service.AccountService;

/**
 * 
 * @author SJ
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	AccountDAO accountDAO;
	
	@Autowired
	OrderDAO orderDAO;	



}