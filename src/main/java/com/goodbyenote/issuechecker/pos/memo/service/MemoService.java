package com.goodbyenote.issuechecker.pos.memo.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.goodbyenote.issuechecker.pos.model.MemoVO;

/**
 * 
 * @author SJ
 * 
 */
public interface MemoService {

	void setSelCustomerRequest(Map parametaMap) throws JsonParseException, JsonMappingException, IOException;

	List<Map> getMemoList(Map parametaMap);

	void setMemoRegister(Map parametaMap);



}