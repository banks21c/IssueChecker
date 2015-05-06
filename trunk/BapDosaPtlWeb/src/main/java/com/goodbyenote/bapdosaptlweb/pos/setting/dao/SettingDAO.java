package com.goodbyenote.bapdosaptlweb.pos.setting.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SettingDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertCustomerRequest(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("possetting.insertCustomerRequest", parametaMap);
	}

	public List<Map> getCustomerRequestList(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("possetting.getCustomerRequestList", parametaMap);
	}

}