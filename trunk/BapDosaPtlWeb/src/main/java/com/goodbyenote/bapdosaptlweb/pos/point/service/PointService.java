package com.goodbyenote.bapdosaptlweb.pos.point.service;

import java.util.List;

import com.goodbyenote.bapdosaptlweb.pos.model.PointVO;

/**
 * 
 * @author SJ
 * 
 */
public interface PointService {
	public void insertTestData();

	public List<PointVO> getList(PointVO menu);

	public int count(PointVO menu);

	public PointVO getDetail(PointVO menu);

	public int insertAction(PointVO menu);

	public int updatePointIschecked(PointVO point);

	public int updatePointIsimportant(PointVO point);

	public List<PointVO> getReservationList(PointVO point);

	public List<PointVO> getCustomerRequestList(PointVO point);
}