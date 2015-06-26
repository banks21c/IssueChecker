package com.goodbyenote.issuechecker.member.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.issuechecker.member.dao.MemberDAO;
import com.goodbyenote.issuechecker.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDAO;

	@Override
	public Map getMemberByBusinessNumber(Map parametaMap) {
		// TODO Auto-generated method stub
		return memberDAO.getMemberByBusinessNumber(parametaMap);
	}

	@Override
	public List<Map> getMemberList(Map param) {
		return memberDAO.getMemberList(param);
	}

	@Override
	public Map getMemberDetail(Map param) {
		return memberDAO.getMemberDetail(param);
	}

	@Override
	public int saveMember(Map param) {
		return memberDAO.saveMember(param);
	}

	@Override
	public int deleteMember(Map param) {
		return memberDAO.deleteMember(param);
	}

}
