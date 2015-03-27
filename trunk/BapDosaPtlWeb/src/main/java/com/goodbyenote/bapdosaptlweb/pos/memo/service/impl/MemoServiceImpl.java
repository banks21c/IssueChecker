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
	public List<MemoVO> getList(MemoVO memo) {
		return memoDAO.getList(memo);
	}

	@Override
	public int count(MemoVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemoVO getDetail(MemoVO memo) {
		return memoDAO.getDetail(memo);
	}

	@Override
	public int insertAction(MemoVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int updateMemoIschecked(MemoVO memo){
		return memoDAO.updateMemoIschecked(memo);
	}
	public int updateMemoIsimportant(MemoVO memo){
		return memoDAO.updateMemoIsimportant(memo);
	}

	@Override
	public List<MemoVO> getReservationList(MemoVO memo) {
		return memoDAO.getReservationList(memo);
	}

	@Override
	public List<MemoVO> getCustomerRequestList(MemoVO memo) {
		return memoDAO.getCustomerRequestList(memo);
	}

}