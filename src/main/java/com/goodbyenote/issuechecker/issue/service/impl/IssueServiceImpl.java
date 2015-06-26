package com.goodbyenote.issuechecker.issue.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.issuechecker.issue.dao.IssueDAO;
import com.goodbyenote.issuechecker.issue.service.IssueService;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	IssueDAO issueDAO;

	@Override
	public List<Map> getIssueList(Map param) {
		return issueDAO.getIssueList(param);
	}

	@Override
	public Map getIssueDetail(Map param) {
		return issueDAO.getIssueDetail(param);
	}

	@Override
	public int saveIssue(Map param) {
		return issueDAO.saveIssue(param);
	}

	@Override
	public List<Map> getChargePersonList() {
		return issueDAO.getChargePersonList();
	}

	@Override
	public int saveIssueEventHistory(Map param) {
		return issueDAO.saveIssueEventHistory(param);
	}

	@Override
	public int deleteIssue(Map param) {
		return issueDAO.deleteIssue(param);
	}

	@Override
	public String getIssueId() {
		return issueDAO.getIssueId();
	}

	@Override
	public int insertUserIssueCheck(Map param) {
		return issueDAO.insertUserIssueCheck(param);
	}

	@Override
	public int saveIssueComment(Map param) {
		return issueDAO.saveIssueComment(param);
	}

	@Override
	public List<Map> getCommentList(Map param) {
		return issueDAO.getCommentList(param);
	}
	
	@Override
	public int deleteIssueComment(Map param) {
		return issueDAO.deleteIssueComment(param);
	}

	@Override
	public List<Map> getRegisterIdList(Map param) {
		return  issueDAO.getRegisterIdList(param);
	}

	@Override
	public List<Map> getEventTypeList() {
		return  issueDAO.getEventTypeList();
	}

	@Override
	public List<Map> getIssueHistoryList(Map param) {
		return issueDAO.getIssueHistoryList(param);
	}

	@Override
	public List<Map> getIssueCheckList(Map param) {
		return issueDAO.getIssueCheckList(param);
	}

	@Override
	public int updateCheckStatus(Map param) {
		return issueDAO.updateCheckStatus(param);
		
	}

}
