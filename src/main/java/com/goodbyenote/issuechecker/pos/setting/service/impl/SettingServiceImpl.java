package com.goodbyenote.issuechecker.pos.setting.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.issuechecker.pos.setting.dao.SettingDAO;
import com.goodbyenote.issuechecker.pos.setting.service.SettingService;

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
	public Map getTimezoneSet(Map parametaMap) {
		// TODO Auto-generated method stub
		return settingDAO.getTimezoneSet(parametaMap);
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
	public Map getLunchFront(Map parametaMap) {
		// TODO Auto-generated method stub
		return settingDAO.getLunchFront(parametaMap);
	}
	
	@Override
	public List<Map> getbuildingList(Map parametaMap) {
		// TODO Auto-generated method stub
		return settingDAO.getbuildingList(parametaMap);
	}
	
	@Override
	public Map getDeliveryColllectMenu(Map parametaMap) {
		// TODO Auto-generated method stub
		return settingDAO.getDeliveryColllectMenu(parametaMap);
	}
	
	@Override
	public Map getDeliveryCustomerInfo(Map parametaMap) {
		// TODO Auto-generated method stub
		return settingDAO.getDeliveryCustomerInfo(parametaMap);
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
	public void updateTimezoneSet(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.updateTimezoneSet(parametaMap);
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
	
	@Override
	public void updateBuildingList(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.updateBuildingList(parametaMap);
	}
	
	@Override
	public void updateDeliveryCollectMenu(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.updateDeliveryCollectMenu(parametaMap);
	}
	
	@Override
	public void updateDeliveryCustomerInfo(Map parametaMap) {
		// TODO Auto-generated method stub
		settingDAO.updateDeliveryCustomerInfo(parametaMap);
	}

}
