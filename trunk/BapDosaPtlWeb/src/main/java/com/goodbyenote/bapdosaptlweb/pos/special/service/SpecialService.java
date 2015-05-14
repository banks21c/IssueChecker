package com.goodbyenote.bapdosaptlweb.pos.special.service;

import java.util.Map;

public interface SpecialService {

	void setTableMove(Map parametaMap);

	void setTableShare(Map parametaMap);

	int setTableShareDelOk(Map parametaMap);

	void setTableConnect(Map<String, Object> connectTableInfoMap);

	void setTableConnectCancel(Map parametaMap);
	
	void updateOrderTable(Map parametaMap);

}
