package com.goodbyenote.bapdosaptlweb.pos.order.service.impl;

import java.math.BigDecimal;
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
import com.goodbyenote.bapdosaptlweb.pos.customer.dao.CustomerDAO;
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
	
	@Autowired
	CustomerDAO customerDAO;

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
	public String orderSave(Map<String, Object> orderObjMap,
			SessionUserInfo sessionUserInfo) {
		// TODO Auto-generated method stub
		
		String tableId = (String)orderObjMap.get("tableId");
		String orderId = (String)orderObjMap.get("orderId");
		String customerId = (String)orderObjMap.get("customerId");
		String istakeoutorder = (String)orderObjMap.get("isTakeoutOrder");
		

		
		if("".equals(orderId)){
			
			orderId = SecurityUtils.getTimeFormatUnique();	
			String startsalesdate = DateUtil.getFormatStrFromDate(DateUtil.getDateAdd(new Date(), "h", -6), "YYYYMMdd");
			
			Map paramMap = new HashMap();
			paramMap.put("memberId", sessionUserInfo.getMemberId());
			paramMap.put("deviceId", sessionUserInfo.getDeviceId());
			paramMap.put("tableId", tableId);	
			paramMap.put("orderId", orderId);			
			paramMap.put("startsalesdate", startsalesdate);		
			paramMap.put("customerId", customerId);
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
			paramMap.put("istakeoutorder", istakeoutorder);
			
			System.out.println(paramMap);
			orderDAO.insertTableOrder(paramMap);			
		} else {
			Map paramMap = new HashMap();
			paramMap.put("memberId", sessionUserInfo.getMemberId());
			paramMap.put("orderId", orderId);	
			paramMap.put("customerId", customerId);
			
			orderDAO.updateTableOrder(paramMap);
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
						System.out.println(orderData);
						orderDAO.updateOrderDetail(orderData);
					}
					
				}
				
			}
		);
		
		//orderDataList 에 없는 orderdetail id 리스트 삭제
		Map delMap = new HashMap();
		delMap.put("orderId", orderId);
		delMap.put("orderDataList", orderDataList);
		orderDAO.deleteOrderDetailList(delMap);
				
		return orderId;
	}

	@Override
	public List<Map> getOrderDetailList(Map parametaMap) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderDetailList(parametaMap);
	}

	@Override
	public Map getTableOrder(Map parametaMap) {
		// TODO Auto-generated method stub
		return orderDAO.getTableOrder(parametaMap);
	}

	@Override
	public void setAccountComplete(Map parametaMap) {
		// TODO Auto-generated method stub
		orderDAO.updateTableOrder(parametaMap);
		
		String customerId = (String)parametaMap.get("customerId");
		
		System.out.println("customerId: " + customerId);
		
		if(customerId != null && !"".equals(customerId)){
			
//			#{memberId}
//			,#{deviceId}
//			,#{customerTradeId}
//			,#{startSalesDate}
//			,#{customerId}
//			,#{tradeType}
//			,#{tradeId}
//			,#{contents}
//			,#{bill}
//			,#{payment}
//			,#{credit}
//			,#{totalDeposit}
//			,#{totalCredit}
//			,#{isDeleted}	
			
			Map customerMap = customerDAO.getCustomer(parametaMap);
			long totalDeposit =  ((BigDecimal)customerMap.get("TOTALDEPOSIT")).longValue();
			long totalCredit =  ((BigDecimal)customerMap.get("TOTALCREDIT")).longValue();
			long billmoney = Long.valueOf(((String)parametaMap.get("billmoney")));	
			long givebackcredit = Long.valueOf(((String)parametaMap.get("givebackcredit")));	//외상상환금액(거스름돈외상갚기금액포함)
			long intodeposit = Long.valueOf(((String)parametaMap.get("intodeposit")));	//예치금정립금액
			long useddeposit = Long.valueOf(((String)parametaMap.get("useddeposit")));	//예치금사용금액
			long intocredit = Long.valueOf(((String)parametaMap.get("intocredit")));		//외상처리금액
			long bill = billmoney - givebackcredit;	//음식금액 : 청구금액-외상상환금액(거스름돈외상갚기금액포함)
			long payment = bill - intocredit;
			
			totalDeposit = totalDeposit + intodeposit - useddeposit;
			totalCredit = totalCredit + intocredit;			
			
			String customerTradeId = SecurityUtils.getTimeFormatUnique();
			Map customerTradeMap = new HashMap();
			customerTradeMap.put("memberId", parametaMap.get("memberId"));
			customerTradeMap.put("deviceId", parametaMap.get("deviceId"));
			customerTradeMap.put("customerTradeId", customerTradeId);
			customerTradeMap.put("startSalesDate", parametaMap.get("startSalesDate"));
			customerTradeMap.put("customerId", parametaMap.get("customerId"));
			customerTradeMap.put("tradeType", "A");
			customerTradeMap.put("tradeId", parametaMap.get("orderId"));
			customerTradeMap.put("contents", parametaMap.get("contents"));
			customerTradeMap.put("bill", bill);		//음식금액 : 청구금액-외상상환금액(거스름돈외상갚기금액포함)
			customerTradeMap.put("payment", payment);					//결재금액 = 음식음액 - 외상처리금액
			customerTradeMap.put("credit", parametaMap.get("intocredit"));	//외상처리금액
			//customerTradeMap.put("totalDeposit", parametaMap.get("intodeposit"));		//?외상처리금액
			customerTradeMap.put("totalCredit", totalCredit);		//외상잔액
			customerTradeMap.put("isDeleted", "N");
			System.out.println(customerTradeMap);
			customerDAO.insertCustomerTrade(customerTradeMap);
			
			//주문시 외상상환금액이 있을경우 외상상처리 고객원장 등록
			if(givebackcredit > 0){
				totalCredit = totalCredit - givebackcredit;
				customerTradeId = SecurityUtils.getTimeFormatUnique();
				customerTradeMap.clear();
				customerTradeMap.put("memberId", parametaMap.get("memberId"));
				customerTradeMap.put("deviceId", parametaMap.get("deviceId"));
				customerTradeMap.put("customerTradeId", customerTradeId);
				customerTradeMap.put("startSalesDate", parametaMap.get("startSalesDate"));
				customerTradeMap.put("customerId", parametaMap.get("customerId"));
				customerTradeMap.put("tradeType", "C");
				customerTradeMap.put("tradeId", parametaMap.get("orderId"));
				customerTradeMap.put("contents", "주문시외상상환");
				customerTradeMap.put("bill", 0);		//음식금액 : 외상상환금액
				customerTradeMap.put("payment", givebackcredit);					//결재금액 = 외상상환금액
				customerTradeMap.put("credit", parametaMap.get("intocredit"));	//외상처리금액
				//customerTradeMap.put("totalDeposit", parametaMap.get("intodeposit"));		//?외상처리금액
				customerTradeMap.put("totalCredit", totalCredit);		//외상잔액
				customerTradeMap.put("isDeleted", "N");
				System.out.println(customerTradeMap);
				customerDAO.insertCustomerTrade(customerTradeMap);
			}
			
			Map customerParamMap = new HashMap();
			customerParamMap.put("memberId", parametaMap.get("memberId"));
			customerParamMap.put("customerId", customerId);
			customerParamMap.put("totalSales", parametaMap.get("intodeposit"));		//?외상처리금액
			customerParamMap.put("totalCredit", totalCredit);		//외상잔액
			customerParamMap.put("totalDeposit", totalDeposit);		//예치금잔액
			
			System.out.println(customerParamMap);
			customerDAO.updateCustomer(customerParamMap);
			
			Long savedpoint = Long.valueOf(((String)parametaMap.get("savedpoint")));	
			if(savedpoint > 0){
				
				Map pointSumMap = customerDAO.getSumPoint(customerParamMap);
				
				Long remainPoint = ((BigDecimal)pointSumMap.get("REMAINPOINT")).longValue();
				remainPoint += savedpoint;
				
				Map pointMap = new HashMap();
				pointMap.put("memberId", parametaMap.get("memberId"));
				pointMap.put("deviceId", parametaMap.get("deviceId"));
				pointMap.put("customerId", parametaMap.get("customerId"));
				pointMap.put("pointId", SecurityUtils.getTimeFormatUnique());	
				pointMap.put("pointType", "CC00001101");	//주문적립
				pointMap.put("orderId", parametaMap.get("orderId"));
				pointMap.put("deliverymasterId", "");
				pointMap.put("addPoint", savedpoint);
				pointMap.put("usedPoint", 0);
				pointMap.put("remainPoint", remainPoint);
				
				customerDAO.insertPoint(pointMap);
			}
		}
		
		
	}

}