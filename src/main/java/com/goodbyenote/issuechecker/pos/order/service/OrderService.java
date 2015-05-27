package com.goodbyenote.issuechecker.pos.order.service;

import java.util.List;
import java.util.Map;

import com.goodbyenote.issuechecker.common.model.SessionUserInfo;
import com.goodbyenote.issuechecker.pos.model.OrderVO;

/**
 * 
 * @author SJ
 * 
 */
public interface OrderService {
	public void insertTestData();

	public List<OrderVO> getList(OrderVO menu);

	public int count(OrderVO menu);

	public OrderVO getDetail(OrderVO menu);

	public int insertAction(OrderVO menu);

	public int updateOrderIschecked(OrderVO order);

	public int updateOrderIsimportant(OrderVO order);

	public List<Map> getOrderTablePresentList(Map parametaMap);

	public String orderSave(Map<String, Object> orderObjMap,
			SessionUserInfo sessionUserInfo);

	public List<Map> getOrderDetailList(Map parametaMap);

	public Map getTableOrder(Map parametaMap);

	public void setAccountComplete(Map parametaMap);
}