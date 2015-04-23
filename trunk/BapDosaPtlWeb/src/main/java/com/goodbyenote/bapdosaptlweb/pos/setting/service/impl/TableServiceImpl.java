package com.goodbyenote.bapdosaptlweb.pos.setting.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.pos.setting.dao.TableDAO;
import com.goodbyenote.bapdosaptlweb.pos.setting.service.TableService;

@Service
public class TableServiceImpl implements TableService {
	
	private static final Logger logger = LoggerFactory.getLogger(TableServiceImpl.class);
	
	@Autowired
	TableDAO tableDAO;

	@Override
	public Map getOrderTable(Map parametaMap) {
		// TODO Auto-generated method stub
		return tableDAO.getOrderTable(parametaMap);
	}

}
