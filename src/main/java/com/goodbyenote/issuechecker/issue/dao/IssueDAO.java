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
		if(param.get("crud").equals("u")){
			return sqlSession.insert("issueChecker.updateIssue", param);
		}else if(param.get("crud").equals("c")){
			return sqlSession.insert("issueChecker.insertIssue", param);			
		}else return 0;
	}

	public List<Map> getChargePersonList() {
        return sqlSession.selectList("issueChecker.getChargePersonList",null);			
	}

	public int saveIssueEventHistory(Map param) {
        return sqlSession.insert("issueChecker.saveIssueEventHistory", param);			
	}

	public int deleteIssue(Map param) {
        return sqlSession.delete("issueChecker.deleteIssue", param);			
	}

	public String getIssueId() {
        return sqlSession.selectOne("issueChecker.getIssueId",null);			
	}

	public int insertUserIssueCheck(Map param) {
        return sqlSession.insert("issueChecker.insertUserIssueCheck", param);			
	}

	public int saveIssueComment(Map param) {
		return sqlSession.insert("issueChecker.saveIssueComment", param);		
	}

	public List<Map> getCommentList(Map param) {
		return sqlSession.selectList("issueChecker.getCommentList", param);
	}

	public int deleteIssueComment(Map param) {
	    return sqlSession.delete("issueChecker.deleteIssueComment", param);	
	}

	public List<Map> getRegisterIdList(Map param) {
		return sqlSession.selectList("issueChecker.getRegisterIdList", param);
	}

	public List<Map> getEventTypeList() {
		  return sqlSession.selectList("issueChecker.getEventTypeList",null);			
	}

	public List<Map> getIssueHistoryList(Map param) {
		return sqlSession.selectList("issueChecker.getIssueHistoryList", param);
	}

	public List<Map> getIssueCheckList(Map param) {
		return sqlSession.selectList("issueChecker.getIssueCheckList", param);
	}

	public int updateCheckStatus(Map param) {
		return sqlSession.update("issueChecker.updateCheckStatus", param);
	}

}
