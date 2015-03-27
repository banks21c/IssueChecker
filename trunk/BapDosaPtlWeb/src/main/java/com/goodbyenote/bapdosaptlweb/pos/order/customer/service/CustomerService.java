package com.goodbyenote.bapdosaptlweb.pos.order.customer.service;

import java.util.List;

import com.goodbyenote.bapdosaptlweb.pos.model.CustomerVO;

/**
 * 
 * @author SJ
 * 
 */
public interface CustomerService {
	public void insertTestData();

	public List<CustomerVO> getList(CustomerVO customer);

	public int count(CustomerVO customer);

	public int insertAction(CustomerVO customer);

	public CustomerVO getRegularDetail(CustomerVO memo);
}