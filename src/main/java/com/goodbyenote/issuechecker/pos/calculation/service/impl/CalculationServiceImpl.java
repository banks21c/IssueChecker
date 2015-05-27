package com.goodbyenote.issuechecker.pos.calculation.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.issuechecker.pos.calculation.dao.CalculationDAO;
import com.goodbyenote.issuechecker.pos.calculation.service.CalculationService;
import com.goodbyenote.issuechecker.pos.model.CalculationVO;

/**
 * 
 * @author SJ
 *
 */
@Service
public class CalculationServiceImpl implements CalculationService {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculationServiceImpl.class);
	
	@Autowired
	CalculationDAO calculationDAO;

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
	public List<CalculationVO> getList(CalculationVO calculation) {
		return calculationDAO.getList(calculation);
	}

	@Override
	public int count(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CalculationVO getDetail(CalculationVO calculation) {
		return calculationDAO.getDetail(calculation);
	}

	@Override
	public int insertAction(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int updateCaculationIschecked(CalculationVO calculation){
		return calculationDAO.updateCaculationIschecked(calculation);
	}
	public int updateCaculationIsimportant(CalculationVO calculation){
		return calculationDAO.updateCaculationIsimportant(calculation);
	}

	@Override
	public List<CalculationVO> getReservationList(CalculationVO calculation) {
		return calculationDAO.getReservationList(calculation);
	}

	@Override
	public List<CalculationVO> getCustomerRequestList(CalculationVO calculation) {
		return calculationDAO.getCustomerRequestList(calculation);
	}

	@Override
	public int updateCalculationIschecked(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCalculationIsimportant(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return 0;
	}

}