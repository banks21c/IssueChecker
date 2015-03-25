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
}