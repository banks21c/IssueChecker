package com.goodbyenote.bapdosaptlweb.pos.memo.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.goodbyenote.bapdosaptlweb.pos.model.MemoVO;

/**
 * 
 * @author SJ
 * 
 */
public interface MemoService {

	void setSelCustomerRequest(Map parametaMap) throws JsonParseException, JsonMappingException, IOException;



}