package com.goodbyenote.bapdosaptlweb.pos.order.service;

import java.util.List;
import java.util.Map;

import com.goodbyenote.bapdosaptlweb.common.model.SessionUserInfo;
import com.goodbyenote.bapdosaptlweb.pos.model.OrderVO;

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

	public int orderSave(Map<String, Object> orderObjMap,
			SessionUserInfo sessionUserInfo);

	public List<Map> getOrderDetailList(Map parametaMap);
}