package com.goodbyenote.bapdosaptlweb.member.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.member.dao.MemberDAO;
import com.goodbyenote.bapdosaptlweb.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDAO;	

	@Override
	public Map getMemberByBusinessNumber(String businessNumber) {
		// TODO Auto-generated method stub
		return memberDAO.getMemberByBusinessNumber(businessNumber);
	}

}
