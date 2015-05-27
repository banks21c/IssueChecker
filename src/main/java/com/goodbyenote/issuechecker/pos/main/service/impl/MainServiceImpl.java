package com.goodbyenote.issuechecker.pos.main.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.issuechecker.pos.main.dao.MainDAO;
import com.goodbyenote.issuechecker.pos.main.service.MainService;
import com.goodbyenote.issuechecker.pos.model.MainVO;

/**
 * 
 * @author SJ
 *
 */
@Service
public class MainServiceImpl implements MainService {
	
	private static final Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);
	
	@Autowired
	MainDAO mainDAO;

	/**
	 * TEST 용도 데이터 삽입
	 */
	@Override
	public void insertTestData(){ 
		logger.info("test test insertTestData");
		//customerDAO.insertTestData();		
		//memberDAO.insertTestData();
	}

	@Override
	public List<MainVO> getList(MainVO menu) {
		return mainDAO.getList(menu);
	}

	@Override
	public int count(MainVO menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MainVO getDetail(MainVO menu) {
		return mainDAO.getDetail(menu);
	}

	@Override
	public int insertAction(MainVO menu) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int updateMainIschecked(MainVO main){
		return mainDAO.updateMainIschecked(main);
	}
	public int updateMainIsimportant(MainVO main){
		return mainDAO.updateMainIsimportant(main);
	}

}