package com.goodbyenote.issuechecker.issue.service;

import java.util.List;
import java.util.Map;

public interface IssueService {

	List<Map> getIssueList(Map param);

	Map getIssueDetail(Map param);

	int saveIssue(Map parametaMap);

	List<Map> getChargePersonList();

}
