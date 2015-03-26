package com.goodbyenote.bapdosaptlweb.pos.order.customer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.bapdosaptlweb.pos.model.CustomerVO;

@Repository
public class CustomerDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertTestData() {
		List<CustomerVO> menus = new ArrayList<CustomerVO>(13);
		
        for(CustomerVO m : menus){
        	sqlSession.insert("pos.insertMemo", m);	
        }
	}

	public List<CustomerVO> getList(CustomerVO memo) {
		return sqlSession.selectList("CustomerMapper.getList",memo);
	}

	public int count(CustomerVO memo) {
		return (Integer)sqlSession.selectOne("CustomerMapper.count",memo);
	}

	public List<Map<String, ?>> listExcel(CustomerVO memo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map> listExcel2(CustomerVO memo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CustomerVO> detailList(CustomerVO memo) {
		return null;
	}

	public CustomerVO getDetailSum(CustomerVO memo) {
		return (CustomerVO)sqlSession.selectOne("CustomerMapper.getViewData",memo);
	}

	public CustomerVO view(CustomerVO memo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CustomerVO> viewDtl(CustomerVO memo) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertAction(CustomerVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertDtlAction(CustomerVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateAction(CustomerVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteDtlAction(CustomerVO memo) {
		// TODO Auto-generated method stub
		return 0;
		
	}

	public int deleteAction(CustomerVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public CustomerVO viewDtlSum(CustomerVO adjust) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerVO getDetail(CustomerVO menu) {
		return (CustomerVO)sqlSession.selectOne("CustomerMapper.getDetail",menu);

	}
}
