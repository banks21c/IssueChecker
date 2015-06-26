package com.goodbyenote.issuechecker.issue.service;

import java.util.List;
import java.util.Map;

public interface IssueService {

	List<Map> getIssueList(Map param);

	Map getIssueDetail(Map param);

	int saveIssue(Map parametaMap);

	List<Map> getChargePersonList();

	int saveIssueEventHistory(Map param);

	int deleteIssue(Map param);

	String getIssueId();

	int insertUserIssueCheck(Map param);

	int saveIssueComment(Map param);

	List<Map> getCommentList(Map param);

	int deleteIssueComment(Map param);

	List<Map> getRegisterIdList(Map param);

	List<Map> getEventTypeList();

	List<Map> getIssueHistoryList(Map param);

	List<Map> getIssueCheckList(Map param);

	int updateCheckStatus(Map param);
}
