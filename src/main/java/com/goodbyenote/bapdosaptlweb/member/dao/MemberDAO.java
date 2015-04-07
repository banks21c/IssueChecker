package com.goodbyenote.bapdosaptlweb.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	public Map getMemberByBusinessNumber(String businessNumber) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.getMemberByBusinessNumber", businessNumber);
	}
}
