package com.goodbyenote.bapdosaptlweb.pos.setting.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SettingDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertCustomerRequest(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.insert("possetting.insertCustomerRequest", parametaMap);
	}

	public List<Map> getCustomerRequestList(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("possetting.getCustomerRequestList", parametaMap);
	}
	
	public Map getTimezoneSet(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("possetting.getTimezoneSet", parametaMap);
	}
	
	public List<Map> getPointDcList(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("possetting.getPointDcList", parametaMap);
	}
	
	public List<Map> getRankList(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("possetting.getRankList", parametaMap);
	}
	
	public List<Map> getRankList2(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("possetting.getRankList2", parametaMap);
	}
	
	public Map getLunchFront(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("possetting.getLunchFront", parametaMap);
	}
	
	public List<Map> getbuildingList(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("possetting.getbuildingList", parametaMap);
	}
	
	public Map getDeliveryColllectMenu(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("possetting.getDeliveryColllectMenu", parametaMap);
	}
	
	public Map getDeliveryCustomerInfo(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("possetting.getDeliveryCustomerInfo", parametaMap);
	}
	
	public void updateTableCount(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.update("possetting.updateTableCount", parametaMap);
	}
	
	public void updateTableCount2(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.update("possetting.updateTableCount2", parametaMap);
	}
	
	public void updateTimezoneSet(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.update("possetting.updateTimezoneSet", parametaMap);
	}
	
	public void updateDcAmount(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.update("possetting.updateDcAmount", parametaMap);
	}
	
	public void updateRank(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.update("possetting.updateRank", parametaMap);
	}
	
	public void updateCustomerRequest(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.update("possetting.updateCustomerRequest", parametaMap);
	}
	
	public void updateLunchFront(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.update("possetting.updateLunchFront", parametaMap);
	}
	
	public void updateBuildingList(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.update("possetting.updateBuildingList", parametaMap);
	}
	
	public void updateDeliveryCollectMenu(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.update("possetting.updateDeliveryCollectMenu", parametaMap);
	}
	
	public void updateDeliveryCustomerInfo(Map parametaMap) {
		// TODO Auto-generated method stub
		sqlSession.update("possetting.updateDeliveryCustomerInfo", parametaMap);
	}

}
