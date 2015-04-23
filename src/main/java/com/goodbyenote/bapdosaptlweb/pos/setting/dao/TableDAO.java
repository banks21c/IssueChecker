package com.goodbyenote.bapdosaptlweb.pos.setting.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TableDAO {
	@Autowired
	private SqlSession sqlSession;

	public Map getOrderTable(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("postable.getOrderTable", parametaMap);
	}
}
