package com.goodbyenote.bapdosaptlweb.pos.order.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.bapdosaptlweb.pos.model.OrderVO;

@Repository
public class OrderDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertTestData() {
		List<OrderVO> menus = new ArrayList<OrderVO>(13);

		for (OrderVO m : menus) {
			sqlSession.insert("pos.insertOrder", m);
		}
	}

	public List<OrderVO> getList(OrderVO order) {
		return sqlSession.selectList("OrderMapper.getList", order);
	}

	public int count(OrderVO order) {
		return (Integer) sqlSession.selectOne("OrderMapper.count", order);
	}

	public List<Map<String, ?>> listExcel(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map> listExcel2(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> detailList(OrderVO order) {
		return null;
	}

	public OrderVO getDetailSum(OrderVO order) {
		return (OrderVO) sqlSession.selectOne("OrderMapper.getViewData", order);
	}

	public OrderVO view(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> viewDtl(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertAction(OrderVO order) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertDtlAction(OrderVO order) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateAction(OrderVO order) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteDtlAction(OrderVO order) {
		// TODO Auto-generated method stub
		return 0;

	}

	public int deleteAction(OrderVO order) {
		// TODO Auto-generated method stub
		return 0;
	}

	public OrderVO viewDtlSum(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO getDetail(OrderVO order) {
		return (OrderVO) sqlSession.selectOne("OrderMapper.getDetail", order);

	}

	public int updateOrderIschecked(OrderVO order) {
		return sqlSession.update("OrderMapper.updateOrderIschecked", order);
	}

	public int updateOrderIsimportant(OrderVO order) {
		return sqlSession.update("OrderMapper.updateOrderIsimportant", order);
	}

	public List<Map> getOrderTablePresentList(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("posorder.getOrderTablePresentList", parametaMap);
	}

	public void insertTableOrder(Map orderMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("posorder.insertTableOrder", orderMap);
	}

	public void insertOrderDetail(Map orderData) {
		// TODO Auto-generated method stub
		sqlSession.insert("posorder.insertOrderDetail", orderData);
	}

	public Map selectOrderDetail(Map orderData) {
		// TODO Auto-generated method stub
		return (Map) sqlSession.selectOne("posorder.selectOrderDetail", orderData);
	}

	public void updateOrderDetail(Map orderData) {
		// TODO Auto-generated method stub
		sqlSession.insert("posorder.updateOrderDetail", orderData);
	}

	public List<Map> getOrderDetailList(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("posorder.getOrderDetailList", parametaMap);
	}

	public void updateTableOrder(Map paramMap) {
		// TODO Auto-generated method stub
		sqlSession.update("posorder.updateTableOrder", paramMap);
	}

	public Map getTableOrder(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("posorder.getTableOrder", parametaMap);
	}

	public void deleteOrderDetailList(Map delMap) {
		// TODO Auto-generated method stub
		sqlSession.delete("posorder.deleteOrderDetailList", delMap);
	}


}
