package com.goodbyenote.bapdosaptlweb.pos.customer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public void insertCustomer(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("poscustomer.insertCustomer", parametaMap);
	}

	public Map getCustomer(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("poscustomer.getCustomer", parametaMap);
	}

	public List<Map> getCustomerList(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("poscustomer.getCustomerList", parametaMap);
	}

	public int getCustomerListCount(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("poscustomer.getCustomerListCount", parametaMap);
	}

	public void updateCustomer(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.update("poscustomer.updateCustomer", parametaMap);
	}

	public void insertCustomerTrade(Map customerTradeMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("poscustomer.insertCustomerTrade", customerTradeMap);
	}

	public Map getSumPoint(Map customerParamMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("poscustomer.getSumPoint", customerParamMap);
	}

	public void insertPoint(Map pointMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("poscustomer.insertPoint", pointMap);
	}

}
