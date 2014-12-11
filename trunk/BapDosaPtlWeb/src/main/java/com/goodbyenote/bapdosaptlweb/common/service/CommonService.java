package com.goodbyenote.bapdosaptlweb.common.service;

import java.util.List;
import java.util.Map;

import com.goodbyenote.bapdosaptlweb.common.model.CommonCodeVO;
import com.goodbyenote.bapdosaptlweb.common.model.MenuVO;

public interface CommonService {
	
	List<CommonCodeVO> getCommonCodeList();

	List<CommonCodeVO> getCommonCodeParents();

	//void insertAccessLog(Map<String, String> paramMap);
	
}
