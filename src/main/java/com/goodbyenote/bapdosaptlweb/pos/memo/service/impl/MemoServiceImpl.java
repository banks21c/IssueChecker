package com.goodbyenote.bapdosaptlweb.pos.memo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.pos.memo.dao.MemoDAO;
import com.goodbyenote.bapdosaptlweb.pos.memo.service.MemoService;
import com.goodbyenote.bapdosaptlweb.pos.model.MemoVO;

/**
 * 
 * @author SJ
 *
 */
@Service
public class MemoServiceImpl implements MemoService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemoServiceImpl.class);
	
	@Autowired
	MemoDAO memoDAO;

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
	public List<MemoVO> getList(MemoVO menu) {
		return memoDAO.getList(menu);
	}

	@Override
	public int count(MemoVO menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemoVO getDetail(MemoVO menu) {
		return memoDAO.getDetail(menu);
	}

	@Override
	public int insertAction(MemoVO menu) {
		// TODO Auto-generated method stub
		return 0;
	}
}