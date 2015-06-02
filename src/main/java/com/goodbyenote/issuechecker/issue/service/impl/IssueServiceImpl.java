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

}
