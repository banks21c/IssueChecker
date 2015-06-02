package com.goodbyenote.issuechecker.issue.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession sqlSession;

	public Map<?, ?> getLoginUser(Map<?, ?> param) {
		System.out.println("param:"+param);
		return sqlSession.selectOne("issueChecker.getLoginUser", param);
	}

}
