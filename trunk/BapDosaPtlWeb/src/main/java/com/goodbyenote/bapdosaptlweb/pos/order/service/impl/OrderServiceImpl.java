package com.goodbyenote.bapdosaptlweb.pos.order.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}