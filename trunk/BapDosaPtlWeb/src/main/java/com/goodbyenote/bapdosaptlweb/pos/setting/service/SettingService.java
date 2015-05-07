package com.goodbyenote.bapdosaptlweb.pos.setting.service;

import java.util.List;
import java.util.Map;

public interface SettingService {

	void setCustomerRequest(Map parametaMap);

	List<Map> getCustomerRequestList(Map parametaMap);
	
	void updateTableCount(Map parametaMap);
	
	void updateTableCount2(Map parametaMap);
	
	void updateCustomerRequest(Map parametaMap);

}
