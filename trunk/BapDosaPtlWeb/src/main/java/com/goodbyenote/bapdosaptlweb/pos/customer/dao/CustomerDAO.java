package com.goodbyenote.bapdosaptlweb.pos.customer.dao;

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

}
