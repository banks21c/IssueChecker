package com.goodbyenote.issuechecker.common.service;

import java.util.List;
import java.util.Map;

import com.goodbyenote.issuechecker.common.model.CommonCodeVO;
import com.goodbyenote.issuechecker.common.model.ExceptionVO;
import com.goodbyenote.issuechecker.common.model.MenuVO;

public interface CommonService {
	
	List<CommonCodeVO> getCommonCodeList();

	List<CommonCodeVO> getCommonCodeParents();

	void insertExceptionLog(ExceptionVO exceptionVO);

	//void insertAccessLog(Map<String, String> paramMap);
	
}
