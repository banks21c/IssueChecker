package com.goodbyenote.issuechecker.member.service;

import java.util.List;
import java.util.Map;

public interface MemberService {

	Map getMemberByBusinessNumber(Map parametaMap);

	List<Map> getMemberList(Map param);

	Map getMemberDetail(Map param);

	int saveMember(Map param);

	int deleteMember(Map param);

}
