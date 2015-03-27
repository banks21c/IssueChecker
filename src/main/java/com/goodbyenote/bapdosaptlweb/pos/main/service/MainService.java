package com.goodbyenote.bapdosaptlweb.pos.main.service;

import java.util.List;

import com.goodbyenote.bapdosaptlweb.pos.model.MainVO;

/**
 * 
 * @author SJ
 * 
 */
public interface MainService {
	public void insertTestData();

	public List<MainVO> getList(MainVO menu);

	public int count(MainVO menu);

	public MainVO getDetail(MainVO menu);

	public int insertAction(MainVO menu);

	public int updateMainIschecked(MainVO main);

	public int updateMainIsimportant(MainVO main);
}