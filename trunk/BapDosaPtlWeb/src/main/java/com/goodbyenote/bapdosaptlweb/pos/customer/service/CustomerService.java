package com.goodbyenote.bapdosaptlweb.pos.customer.service;

import java.util.List;
import java.util.Map;

public interface CustomerService {

	void insertCustomer(Map parametaMap);

	Map getCustomer(Map parametaMap);

	List<Map> getCustomerList(Map parametaMap);

	int getCustomerListCount(Map parametaMap);

}
