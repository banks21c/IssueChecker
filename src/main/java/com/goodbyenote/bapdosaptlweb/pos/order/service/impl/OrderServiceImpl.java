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
			String startsalesdate = DateUtil.getFormatStrFromDate(DateUtil.getDateAdd(new Date(), "h", -6), "YYYYMMdd");
			
			Map paramMap = new HashMap();
			paramMap.put("memberId", sessionUserInfo.getMemberId());
			paramMap.put("deviceId", sessionUserInfo.getDeviceId());
			paramMap.put("tableId", tableId);	
			paramMap.put("orderId", orderId);			
			paramMap.put("startsalesdate", startsalesdate);		
			paramMap.put("customerId", null);
			paramMap.put("price", 0);
//			paramMap.put("givebackcredit", null);
//			paramMap.put("loss", null);
//			paramMap.put("discount", null);
//			paramMap.put("billmoney", null);
//			paramMap.put("cashpayment", null);
//			paramMap.put("cardpayment", null);
//			paramMap.put("intocredit", null);
//			paramMap.put("intoloss", null);
//			paramMap.put("intodeposit", null);
//			paramMap.put("usedticket", null);
//			paramMap.put("savedpoint", null);
//			paramMap.put("useddeposit", null);
//			paramMap.put("usedpoint", null);
//			paramMap.put("ischangeaftermerge", null);
			
			System.out.println(paramMap);
			orderDAO.insertTableOrder(paramMap);			
		} 

				
		
		List<Map> orderDataList = (List<Map>)orderObjMap.get("orderDataList");
		String orderIdFinal = orderId;
		orderDataList.forEach( 
			orderData -> {
				System.out.println(orderData);
//				orderDetailId : orderDetailId,
//				menuId: menuId,
//				quantity: orderCount,
//				isTakeout: isTakeout,
//				isService: isService,
//				originalPrice: originalPrice,
//				newFlag: newFlag	
				
				orderData.put("memberId", sessionUserInfo.getMemberId());
				orderData.put("deviceId", sessionUserInfo.getDeviceId());				
				orderData.put("tableId", (String)orderObjMap.get("tableId"));
				orderData.put("orderId", orderIdFinal);
				
				String orderDetailId = (String)orderData.get("orderDetailId");
				String newFlag = (String)orderData.get("newFlag");
				if("Y".equals(newFlag) && "".equals(orderDetailId)){
					orderData.put("orderDetailId", SecurityUtils.getTimeFormatUnique());
					
					System.out.println(orderData);
					orderDAO.insertOrderDetail(orderData);
				}
				else {
					Map selMap = orderDAO.selectOrderDetail(orderData);
					
					if(selMap != null){
						orderDAO.updateOrderDetail(orderData);
					}
					
				}
				
			}
		);
				
		return 1;
	}

	@Override
	public List<Map> getOrderDetailList(Map parametaMap) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderDetailList(parametaMap);
	}

}