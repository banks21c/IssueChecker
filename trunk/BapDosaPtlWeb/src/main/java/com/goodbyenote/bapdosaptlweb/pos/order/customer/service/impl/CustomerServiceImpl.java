package com.goodbyenote.bapdosaptlweb.pos.order.customer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.pos.model.CustomerVO;
import com.goodbyenote.bapdosaptlweb.pos.order.customer.dao.CustomerDAO;
import com.goodbyenote.bapdosaptlweb.pos.order.customer.service.CustomerService;

/**
 * 
 * @author SJ
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerDAO customerDAO;

	/**
	 * TEST 용도 데이터 삽입
	 */
	@Override
	public void insertTestData(){ 
		logger.info("test test insertTestData");
		//customerDAO.insertTestData();		
		//memberDAO.insertTestData();
	}

	@Override
	public List<CustomerVO> getList(CustomerVO menu) {
		return customerDAO.getList(menu);
	}

	@Override
	public int count(CustomerVO menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CustomerVO getDetail(CustomerVO menu) {
		return customerDAO.getDetail(menu);
	}

	@Override
	public int insertAction(CustomerVO menu) {
		// TODO Auto-generated method stub
		return 0;
	}
}