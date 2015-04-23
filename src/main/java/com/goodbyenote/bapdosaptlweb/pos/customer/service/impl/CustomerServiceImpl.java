package com.goodbyenote.bapdosaptlweb.pos.customer.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.pos.customer.dao.CustomerDAO;
import com.goodbyenote.bapdosaptlweb.pos.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerDAO customerDAO;	

	@Override
	public void insertCustomer(Map parametaMap) {
		// TODO Auto-generated method stub
		customerDAO.insertCustomer(parametaMap);
	}

	@Override
	public Map getCustomer(Map parametaMap) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(parametaMap);
	}

	@Override
	public List<Map> getCustomerList(Map parametaMap) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerList(parametaMap);
	}

	@Override
	public int getCustomerListCount(Map parametaMap) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerListCount(parametaMap);
	}

}
