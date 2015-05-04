package com.goodbyenote.bapdosaptlweb.pos.setting.service.impl;

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

}
