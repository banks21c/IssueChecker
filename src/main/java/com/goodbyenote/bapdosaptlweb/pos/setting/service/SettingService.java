package com.goodbyenote.bapdosaptlweb.pos.setting.service;

import java.util.List;
import java.util.Map;

public interface SettingService {

	void setCustomerRequest(Map parametaMap);

	List<Map> getCustomerRequestList(Map parametaMap);
	
	Map getTimezoneSet(Map parametaMap);
	
	List<Map> getPointDcList(Map parametaMap);
	
	List<Map> getRankList(Map parametaMap);
	
	List<Map> getRankList2(Map parametaMap);
	
	List<Map> getLunchFront(Map parametaMap);
	
	void updateTableCount(Map parametaMap);
	
	void updateTableCount2(Map parametaMap);
	
	void updateTimezoneSet(Map parametaMap);
	
	void updateDcAmount(Map parametaMap);
	
	void updateRank(Map parametaMap);
	
	void updateCustomerRequest(Map parametaMap);	
	
	void updateLunchFront(Map parametaMap);
	

}
