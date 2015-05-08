package com.goodbyenote.bapdosaptlweb.pos.memo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.goodbyenote.bapdosaptlweb.common.model.GlobalStatic;
import com.goodbyenote.bapdosaptlweb.common.util.DateUtil;
import com.goodbyenote.bapdosaptlweb.common.util.SecurityUtils;
import com.goodbyenote.bapdosaptlweb.pos.memo.dao.MemoDAO;
import com.goodbyenote.bapdosaptlweb.pos.memo.service.MemoService;
import com.goodbyenote.bapdosaptlweb.pos.model.MemoVO;

/**
 * 
 * @author SJ
 *
 */
@Service
public class MemoServiceImpl implements MemoService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemoServiceImpl.class);
	
	@Autowired
	MemoDAO memoDAO;

	@Override
	public void setSelCustomerRequest(Map parametaMap) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		String memberId = (String)parametaMap.get("memberId");
		String deviceId = (String)parametaMap.get("deviceId");
		String selCustomerRequestJson =  (String)parametaMap.get("selCustomerRequestJson");
		Map selCustomerRequestMap = new ObjectMapper().readValue(selCustomerRequestJson, Map.class) ;
		String orderId = (String)selCustomerRequestMap.get("orderId");
		String tableId = (String)selCustomerRequestMap.get("tableId");
		String startsalesdate = DateUtil.getFormatStrFromDate(DateUtil.getDateAdd(new Date(), "h", -6), "YYYYMMdd");
		List<Map> selCustomerRequestList = (List<Map>)selCustomerRequestMap.get("selCustomerRequestList");
		List<String> notDelList = new ArrayList();
		selCustomerRequestList.forEach(				
			customerRequestMap -> {				
				System.out.println(customerRequestMap);
				String memoId = (String)customerRequestMap.get("memoId");
				if(memoId == null || "".equals(memoId)){
					memoId = SecurityUtils.getTimeFormatUnique();
					customerRequestMap.put("memberId", memberId);
					customerRequestMap.put("deviceId", deviceId);
					customerRequestMap.put("memoId", memoId);
					
					customerRequestMap.put("deliveryMasterId", "");
					customerRequestMap.put("orderId", orderId);
					customerRequestMap.put("startSalesDate", startsalesdate);
					customerRequestMap.put("memoType", GlobalStatic.MEMO_TYPE_CUSTOMER_REQUEST);		//고객요구 CC00001004
					customerRequestMap.put("reservationId", "");
					customerRequestMap.put("tableId", "");
					customerRequestMap.put("isImportant", "");
					customerRequestMap.put("isChecked", "N");
					customerRequestMap.put("isDeleted", "N");
					
//					memoDAO.selectMemo(customerRequestMap);
										
					memoDAO.insertMemo(customerRequestMap);
				}
				
				notDelList.add(memoId);
			}				
		);
		
		Map delMap = new HashMap();
		delMap.put("memberId", memberId);
		delMap.put("orderId", orderId);
		//delMap.put("tableId", tableId);
		delMap.put("memoType", GlobalStatic.MEMO_TYPE_CUSTOMER_REQUEST);
		delMap.put("notDelList", notDelList);
		
		memoDAO.deleteMemo(delMap);
	}

	@Override
	public List<Map> getMemoList(Map parametaMap) {
		// TODO Auto-generated method stub
		return memoDAO.getMemoList(parametaMap);
	}

	@Override
	public void setMemoRegister(Map parametaMap) {
		// TODO Auto-generated method stub

							
		memoDAO.insertMemo(parametaMap);		
	}





}