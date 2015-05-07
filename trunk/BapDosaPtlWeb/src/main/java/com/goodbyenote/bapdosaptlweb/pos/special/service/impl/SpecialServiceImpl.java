package com.goodbyenote.bapdosaptlweb.pos.special.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.pos.order.dao.OrderDAO;
import com.goodbyenote.bapdosaptlweb.pos.special.dao.SpecialDAO;
import com.goodbyenote.bapdosaptlweb.pos.special.service.SpecialService;

@Service
public class SpecialServiceImpl implements SpecialService {
	@Autowired
	SpecialDAO specialDAO;
	
	@Autowired
	OrderDAO orderDAO;	

	@Override
	public void setTableMove(Map parametaMap) {
		// TODO Auto-generated method stub
		
		orderDAO.updateTableOrder(parametaMap);
		orderDAO.updateOrderDetail(parametaMap);
	}	
}
