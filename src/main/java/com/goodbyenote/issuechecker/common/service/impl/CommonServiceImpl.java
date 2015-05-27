package com.goodbyenote.issuechecker.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.issuechecker.common.dao.CommonDAO;
import com.goodbyenote.issuechecker.common.model.CommonCodeVO;
import com.goodbyenote.issuechecker.common.model.ExceptionVO;
import com.goodbyenote.issuechecker.common.model.MenuVO;
import com.goodbyenote.issuechecker.common.service.CommonService;


@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	CommonDAO commonDAO;	

	@Override
	public List<CommonCodeVO> getCommonCodeList() {
		// TODO Auto-generated method stub
		return commonDAO.getCommonCodeList();
	}

	@Override
	public List<CommonCodeVO> getCommonCodeParents() {
		// TODO Auto-generated method stub
		return commonDAO.getCommonCodeParents();
	}

	@Override
	public void insertExceptionLog(ExceptionVO exceptionVO) {
		// TODO Auto-generated method stub
		commonDAO.insertExceptionLog(exceptionVO);
	}
	
	
	
/*
	@Override
	public void insertAccessLog(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		commonDAO.insertAccessLog(paramMap);
	}
*/
	
}
