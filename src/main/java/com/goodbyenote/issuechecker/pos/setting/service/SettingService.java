package com.goodbyenote.issuechecker.pos.setting.service;

import java.util.List;
import java.util.Map;

public interface SettingService {

	void setCustomerRequest(Map parametaMap);

	List<Map> getCustomerRequestList(Map parametaMap);
	
	Map getTimezoneSet(Map parametaMap);
	
	List<Map> getPointDcList(Map parametaMap);
	
	List<Map> getRankList(Map parametaMap);
	
	List<Map> getRankList2(Map parametaMap);
	
	Map getLunchFront(Map parametaMap);
	
	List<Map> getbuildingList(Map parametaMap);
	
	Map getDeliveryColllectMenu(Map parametaMap);
	
	Map getDeliveryCustomerInfo(Map parametaMap);
	
	void updateTableCount(Map parametaMap);
	
	void updateTableCount2(Map parametaMap);
	
	void updateTimezoneSet(Map parametaMap);
	
	void updateDcAmount(Map parametaMap);
	
	void updateRank(Map parametaMap);
	
	void updateCustomerRequest(Map parametaMap);	
	
	void updateLunchFront(Map parametaMap);
	
	void updateBuildingList(Map parametaMap);
	
	void updateDeliveryCollectMenu(Map parametaMap);
	
	void updateDeliveryCustomerInfo(Map parametaMap);
}
