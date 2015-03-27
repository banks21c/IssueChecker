package com.goodbyenote.bapdosaptlweb.pos.memo.service;

import java.util.List;

import com.goodbyenote.bapdosaptlweb.pos.model.MemoVO;

/**
 * 
 * @author SJ
 * 
 */
public interface MemoService {
	public void insertTestData();

	public List<MemoVO> getList(MemoVO menu);

	public int count(MemoVO menu);

	public MemoVO getDetail(MemoVO menu);

	public int insertAction(MemoVO menu);

	public int updateMemoIschecked(MemoVO memo);

	public int updateMemoIsimportant(MemoVO memo);

	public List<MemoVO> getReservationList(MemoVO memo);

	public List<MemoVO> getCustomerRequestList(MemoVO memo);
}