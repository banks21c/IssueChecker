package com.goodbyenote.issuechecker.member.service.impl;

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

}
