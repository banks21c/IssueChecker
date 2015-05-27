package com.goodbyenote.issuechecker.pos.special.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.issuechecker.common.model.GlobalStatic;
import com.goodbyenote.issuechecker.common.util.DateUtil;
import com.goodbyenote.issuechecker.common.util.SecurityUtils;
import com.goodbyenote.issuechecker.pos.memo.dao.MemoDAO;
import com.goodbyenote.issuechecker.pos.order.dao.OrderDAO;
import com.goodbyenote.issuechecker.pos.special.dao.SpecialDAO;
import com.goodbyenote.issuechecker.pos.special.service.SpecialService;

@Service
public class SpecialServiceImpl implements SpecialService {
	@Autowired
	SpecialDAO specialDAO;
	
	@Autowired
	OrderDAO orderDAO;	
	
	@Autowired
	MemoDAO memoDAO;		

	@Override
	public void setTableMove(Map parametaMap) {
		// TODO Auto-generated method stub
		
		orderDAO.updateTableOrder(parametaMap);
		orderDAO.updateOrderDetail(parametaMap);
		Map memoMap = new HashMap();
		
		String memoId = SecurityUtils.getTimeFormatUnique();
		String startsalesdate = DateUtil.getFormatStrFromDate(DateUtil.getDateAdd(new Date(), "h", -6), "YYYYMMdd");
		memoMap.put("memberId", parametaMap.get("memberId"));
		memoMap.put("deviceId", parametaMap.get("deviceId"));
		memoMap.put("memoId", memoId);
		
		memoMap.put("deliveryMasterId", "");
		memoMap.put("orderId", parametaMap.get("orderId"));
		memoMap.put("startSalesDate", startsalesdate);
		memoMap.put("memoType", GlobalStatic.MEMO_TYPE_MOVE);		//이동 CC00001015
		memoMap.put("reservationId", "");
		memoMap.put("requestId", "");
		memoMap.put("tableId", "");
		memoMap.put("contents", parametaMap.get("contents"));
		memoMap.put("isImportant", "N");
		memoMap.put("isChecked", "N");
		memoMap.put("isDeleted", "N");		
		System.out.println(memoMap);
		
		memoDAO.insertMemo(memoMap);
	}

	@Override
	public void setTableShare(Map parametaMap) {
		// TODO Auto-generated method stub
		
		String shareAOrderId = (String)parametaMap.get("orderId");
		String shareBOrderId = (String)parametaMap.get("subOrderId");
		String tableId = (String)parametaMap.get("tableId");
		String memberId = (String)parametaMap.get("memberId");
		String deviceId = (String)parametaMap.get("deviceId");
		String startsalesdate = DateUtil.getFormatStrFromDate(DateUtil.getDateAdd(new Date(), "h", -6), "YYYYMMdd");
		
		Map searchMap = new HashMap();
		searchMap.put("orderId", shareAOrderId);
		Map shareAOrderMap = (Map)orderDAO.getTableOrder(searchMap);
		//Map newOrderMap = (Map)orderMap.clone();
		String newOrderId = SecurityUtils.getTimeFormatUnique();
		
		Map newOrderMap = new HashMap(); 
		newOrderMap.put("memberId", memberId);
		newOrderMap.put("deviceId", deviceId);				
		newOrderMap.put("tableId", tableId);		
		newOrderMap.put("orderId", newOrderId);
		newOrderMap.put("startsalesdate", startsalesdate);
		newOrderMap.put("customerId", shareAOrderMap.get("CUSTOMERID"));
		newOrderMap.put("price", 0);
		// new 주문 생성
		orderDAO.insertTableOrder(newOrderMap);
		
		//기존주문 del
		Map delOrderMap = new HashMap();
		delOrderMap.put("isdeleted", "Y");
		delOrderMap.put("orderId", shareAOrderId);
		orderDAO.updateTableOrder(delOrderMap);
		delOrderMap.put("orderId", shareBOrderId);
		orderDAO.updateTableOrder(delOrderMap);
		
		searchMap.put("memberId", memberId);
		List<Map> shareAOrderDetailList = orderDAO.getOrderDetailList(searchMap);
		searchMap.put("orderId", shareBOrderId);
		List<Map> shareBOrderDetailList = orderDAO.getOrderDetailList(searchMap);
		shareAOrderDetailList.addAll(shareBOrderDetailList);
		
		Map orderDetail = new HashMap();
		orderDetail.put("memberId", memberId);
		orderDetail.put("deviceId", deviceId);				
		orderDetail.put("tableId", tableId);
		orderDetail.put("orderId", newOrderId);	
		//새로운 주문상세 생성
		shareAOrderDetailList.forEach(
				orderData -> {
			System.out.println(orderData);
//			orderDetailId : orderDetailId,
//			menuId: menuId,
//			quantity: orderCount,
//			isTakeout: isTakeout,
//			isService: isService,
//			originalPrice: originalPrice,
//			newFlag: newFlag	
			String isDeleted = (String)orderData.get("ISDELETED");
			// delete 된것은 굳이 넣을 필요 없음
			if(!"Y".equals(isDeleted)){
			
				orderDetail.put("orderDetailId", SecurityUtils.getTimeFormatUnique());	
				
				orderDetail.put("menuId", orderData.get("MENUID"));	
				orderDetail.put("quantity", orderData.get("QUANTITY"));	
				orderDetail.put("isTakeout", orderData.get("ISTAKEOUT"));	
				orderDetail.put("originalPrice", orderData.get("ORIGINALPRICE"));
				orderDetail.put("discountPrice", orderData.get("DISCOUNTPRICE"));
				orderDetail.put("isService", orderData.get("ISSERVICE"));
				orderDAO.insertOrderDetail(orderDetail);
			}
			
		});
		
		Map mergeMap = new HashMap();		
		mergeMap.put("memberId", memberId);
		mergeMap.put("deviceId", deviceId);				
		mergeMap.put("beforeMergeId", SecurityUtils.getTimeFormatUnique());
		mergeMap.put("newOrderId", newOrderId);
		mergeMap.put("orderId", shareAOrderId);
		mergeMap.put("subOrderId", shareBOrderId);
		mergeMap.put("isDeleted", "N");
		//합석테이블 insert
		specialDAO.insertBeforeMerge(mergeMap);
		
		Map memoMap = new HashMap();		
		String memoId = SecurityUtils.getTimeFormatUnique();
		memoMap.put("memberId", parametaMap.get("memberId"));
		memoMap.put("deviceId", parametaMap.get("deviceId"));
		memoMap.put("memoId", memoId);
		
		memoMap.put("deliveryMasterId", "");
		memoMap.put("orderId", newOrderId);
		memoMap.put("startSalesDate", startsalesdate);
		memoMap.put("memoType", GlobalStatic.MEMO_TYPE_SHARE);		//합석 CC00001005
		memoMap.put("reservationId", "");
		memoMap.put("requestId", "");
		memoMap.put("tableId", "");
		memoMap.put("contents", parametaMap.get("contents"));
		memoMap.put("isImportant", "N");
		memoMap.put("isChecked", "N");
		memoMap.put("isDeleted", "N");		
		System.out.println(memoMap);
		//메모insert
		memoDAO.insertMemo(memoMap);		
		
	}

	@Override
	public int setTableShareDelOk(Map parametaMap) {
		// TODO Auto-generated method stub
		int resultValue = 1;
		
		parametaMap.put("isDeleted", "N");
		Map mergeMap = specialDAO.getBeforeMerge(parametaMap);
		
		if(mergeMap == null){
			resultValue = 0;
		} else {
			String beforeMergeId = (String)mergeMap.get("BEFOREMERGEID");
			String shareAOrderId = (String)mergeMap.get("ORDERID");
			String shareBOrderId = (String)mergeMap.get("SUBORDERID");
			
			//기존주문 살리기
			Map delOrderMap = new HashMap();
			delOrderMap.put("isdeleted", "N");
			delOrderMap.put("orderId", shareAOrderId);
			orderDAO.updateTableOrder(delOrderMap);
			delOrderMap.put("orderId", shareBOrderId);
			orderDAO.updateTableOrder(delOrderMap);	
			
			//합석된주문 del
			Map delShareOrderMap = new HashMap();
			delShareOrderMap.put("orderId", parametaMap.get("newOrderId"));
			delShareOrderMap.put("isdeleted", "Y");
			orderDAO.updateTableOrder(delShareOrderMap);		
			
			//new orderId로 생성된 메모 삭제
			Map delMemoMap = new HashMap();
			delMemoMap.put("memberId", parametaMap.get("memberId"));
			delMemoMap.put("orderId", parametaMap.get("newOrderId"));
			memoDAO.deleteMemo(delMemoMap);
			
			//합석테이블 삭제
			Map delMergeMap = new HashMap();
			delMergeMap.put("beforeMergeId", mergeMap.get("BEFOREMERGEID"));
			specialDAO.deleteBeforeMerge(delMergeMap);
		}
		
		return resultValue;
	}

	@Override
	public void setTableConnect(Map<String, Object> connectTableInfoMap) {
		// TODO Auto-generated method stub
		String memberId = (String)connectTableInfoMap.get("memberId");
		String deviceId = (String)connectTableInfoMap.get("deviceId");
		String defaultTableId = (String)connectTableInfoMap.get("defaultTableId");	
		
		List<String> linkedTableList =  (List<String>)connectTableInfoMap.get("linkedTableList");
		Map orderTableMap = new HashMap();
		orderTableMap.put("memberId", memberId);
		orderTableMap.put("deviceId", deviceId);		
		orderTableMap.put("linkedTableId", defaultTableId);		
		linkedTableList.forEach( 
				linkedTableId -> {
					System.out.println(linkedTableId);
				
					orderTableMap.put("tableId", linkedTableId);
					specialDAO.updateOrderTable(orderTableMap);
					
				}
			);		
		
	}

	@Override
	public void setTableConnectCancel(Map parametaMap) {
		// TODO Auto-generated method stub
		specialDAO.cancelOrderTable(parametaMap);
	}	
	
	@Override
	public void updateOrderTable(Map parametaMap) {
		// TODO Auto-generated method stub
		specialDAO.updateOrderTable(parametaMap);
	}
}
