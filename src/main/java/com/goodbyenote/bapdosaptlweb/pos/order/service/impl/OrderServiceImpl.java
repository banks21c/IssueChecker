package com.goodbyenote.bapdosaptlweb.pos.order.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.common.model.SessionUserInfo;
import com.goodbyenote.bapdosaptlweb.common.util.DateUtil;
import com.goodbyenote.bapdosaptlweb.common.util.SecurityUtils;
import com.goodbyenote.bapdosaptlweb.pos.model.OrderVO;
import com.goodbyenote.bapdosaptlweb.pos.order.dao.OrderDAO;
import com.goodbyenote.bapdosaptlweb.pos.order.service.OrderService;

/**
 * 
 * @author SJ
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	OrderDAO orderDAO;

	/**
	 * TEST 용도 데이터 삽입
	 */
	@Override
	public void insertTestData(){ 
		logger.info("test test insertTestData");
		//customerDAO.insertTestData();		
		//memberDAO.insertTestData();
	}

	@Override
	public List<OrderVO> getList(OrderVO menu) {
		return orderDAO.getList(menu);
	}

	@Override
	public int count(OrderVO menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderVO getDetail(OrderVO menu) {
		return orderDAO.getDetail(menu);
	}

	@Override
	public int insertAction(OrderVO menu) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int updateOrderIschecked(OrderVO order){
		return orderDAO.updateOrderIschecked(order);
	}
	public int updateOrderIsimportant(OrderVO order){
		return orderDAO.updateOrderIsimportant(order);
	}

	@Override
	public List<Map> getOrderTablePresentList(Map parametaMap) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderTablePresentList(parametaMap);
	}

	@Override
	public int orderSave(Map<String, Object> orderObjMap,
			SessionUserInfo sessionUserInfo) {
		// TODO Auto-generated method stub
		
		String tableId = (String)orderObjMap.get("tableId");
		String orderId = (String)orderObjMap.get("orderId");
		
		if("".equals(orderId)){
			orderId = SecurityUtils.getTimeFormatUnique();
			Map orderMap = new HashMap();
			orderMap.put("memberId", sessionUserInfo.getMemberId());
			orderMap.put("deviceId", sessionUserInfo.getDeviceId());
			orderMap.put("tableId", tableId);			
			orderMap.put("orderId", orderId);
			
			String startsalesdate = DateUtil.getFormatStrFromDate(DateUtil.getDateAdd(new Date(), "h", -6), "YYYYMMDD");
			orderMap.put("startsalesdate", startsalesdate);
			
			orderDAO.insertTableOrder(orderMap);
			
		}
		
		
		List<Map> orderDataList = (List<Map>)orderObjMap.get("orderDataList");
		
		orderDataList.forEach( 
			orderData -> {
				System.out.println(orderData);
				
				//orderData.put
				
			}
		);
				
		return 0;
	}

}