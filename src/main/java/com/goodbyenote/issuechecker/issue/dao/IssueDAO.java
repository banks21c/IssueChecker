package com.goodbyenote.issuechecker.issue.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.issuechecker.issue.vo.IssueVO;

@Repository
public class IssueDAO {

	@Autowired
	private SqlSession sqlSession;

	public List<Map> getIssueList(Map param) {
		return sqlSession.selectList("issueChecker.getIssueList", param);
	}

	public Map getIssueDetail(Map param) {
		return sqlSession.selectOne("issueChecker.getIssueDetail", param);
	}

	public int saveIssue(Map param) {
		if(param.get("issueId") != null){
			return sqlSession.insert("issueChecker.updateIssue", param);
		}else{
			return sqlSession.insert("issueChecker.insertIssue", param);			
		}
	}

	public List<Map> getChargePersonList() {
        return sqlSession.selectList("issueChecker.getChagePersonList",null);			
	}

}
