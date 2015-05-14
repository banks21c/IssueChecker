package com.goodbyenote.bapdosaptlweb.pos.setting.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.pos.setting.dao.SettingDAO;
import com.goodbyenote.bapdosaptlweb.pos.setting.service.SettingService;

@Service
public class SettingServiceImpl implements SettingService {
	
	@Autowired
	SettingDAO settingDAO;	

	@Override
	public void setCustomerRequest(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.insertCustomerRequest(parametaMap);
	}

	@Override
	public List<Map> getCustomerRequestList(Map parametaMap) {
		// TODO Auto-generated method stub
		return settingDAO.getCustomerRequestList(parametaMap);
	}
	
	@Override
	public List<Map> getLunchTimeList(Map parametaMap) {
		// TODO Auto-generated method stub
		return settingDAO.getLunchTimeList(parametaMap);
	}
	
	@Override
	public List<Map> getPointDcList(Map parametaMap) {
		// TODO Auto-generated method stub
		return settingDAO.getPointDcList(parametaMap);
	}
	
	@Override
	public List<Map> getRankList(Map parametaMap) {
		// TODO Auto-generated method stub
		return settingDAO.getRankList(parametaMap);
	}
	
	@Override
	public List<Map> getRankList2(Map parametaMap) {
		// TODO Auto-generated method stub
		return settingDAO.getRankList2(parametaMap);
	}
	
	@Override
	public List<Map> getLunchFront(Map parametaMap) {
		// TODO Auto-generated method stub
		return settingDAO.getLunchFront(parametaMap);
	}
	
	@Override
	public void updateTableCount(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.updateTableCount(parametaMap);
	}
	
	@Override
	public void updateTableCount2(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.updateTableCount2(parametaMap);
	}
	
	@Override
	public void updateLunchEqual(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.updateLunchEqual(parametaMap);
	}
	
	@Override
	public void updateDcAmount(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.updateDcAmount(parametaMap);
	}
	
	@Override
	public void updateRank(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.updateRank(parametaMap);
	}
	
	@Override
	public void updateCustomerRequest(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.updateCustomerRequest(parametaMap);
	}
	
	@Override
	public void updateLunchFront(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.updateLunchFront(parametaMap);
	}

}
