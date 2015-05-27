package com.goodbyenote.issuechecker.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	public Map getMemberByBusinessNumber(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.getMemberByBusinessNumber", parametaMap);
	}
}
