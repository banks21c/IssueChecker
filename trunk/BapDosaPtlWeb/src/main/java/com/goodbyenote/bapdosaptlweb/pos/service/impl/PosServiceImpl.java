package com.goodbyenote.bapdosaptlweb.pos.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.pos.dao.MemberDriverDAO;
import com.goodbyenote.bapdosaptlweb.pos.service.PosService;

/**
 * 
 * @author SJ
 *
 */
@Service
public class PosServiceImpl implements PosService {
	
	private static final Logger logger = LoggerFactory.getLogger(PosServiceImpl.class);
	
	//@Autowired
	//CustomerDAO customerDAO;
	
	@Autowired
	MemberDriverDAO memberDAO;

	/**
	 * TEST 용도 데이터 삽입
	 */
	@Override
	public void insertTestData(){ 
		logger.info("test test insertTestData");
		//customerDAO.insertTestData();		
		//memberDAO.insertTestData();
	}
}