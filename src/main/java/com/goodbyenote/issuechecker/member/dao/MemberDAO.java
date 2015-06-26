package com.goodbyenote.issuechecker.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	public Map getMemberByBusinessNumber(Map param) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.getMemberByBusinessNumber", param);
	}

	public List<Map> getMemberList(Map param) {
		return sqlSession.selectList("member.getMemberList", param);
	}

	public Map getMemberDetail(Map param) {
		return sqlSession.selectOne("member.getMemberDetail", param);
	}

	public int saveMember(Map param) {
		if(param.get("crud").equals("u")){
			return sqlSession.insert("member.updateMember", param);
		}else if(param.get("crud").equals("c")){
			return sqlSession.insert("member.insertMember", param);			
		}else return 0;
	}

	public int deleteMember(Map param) {
		return sqlSession.insert("member.deleteMember", param);
	}
}
