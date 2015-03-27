package com.goodbyenote.bapdosaptlweb.pos.point.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.pos.point.dao.PointDAO;
import com.goodbyenote.bapdosaptlweb.pos.point.service.PointService;
import com.goodbyenote.bapdosaptlweb.pos.model.PointVO;

/**
 * 
 * @author SJ
 *
 */
@Service
public class PointServiceImpl implements PointService {
	
	private static final Logger logger = LoggerFactory.getLogger(PointServiceImpl.class);
	
	@Autowired
	PointDAO pointDAO;

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
	public List<PointVO> getList(PointVO point) {
		return pointDAO.getList(point);
	}

	@Override
	public int count(PointVO point) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PointVO getDetail(PointVO point) {
		return pointDAO.getDetail(point);
	}

	@Override
	public int insertAction(PointVO point) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int updatePointIschecked(PointVO point){
		return pointDAO.updatePointIschecked(point);
	}
	public int updatePointIsimportant(PointVO point){
		return pointDAO.updatePointIsimportant(point);
	}

	@Override
	public List<PointVO> getReservationList(PointVO point) {
		return pointDAO.getReservationList(point);
	}

	@Override
	public List<PointVO> getCustomerRequestList(PointVO point) {
		return pointDAO.getCustomerRequestList(point);
	}

}