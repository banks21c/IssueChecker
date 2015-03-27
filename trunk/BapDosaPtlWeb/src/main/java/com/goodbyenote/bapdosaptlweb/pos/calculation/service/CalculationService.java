package com.goodbyenote.bapdosaptlweb.pos.calculation.service;

import java.util.List;

import com.goodbyenote.bapdosaptlweb.pos.model.CalculationVO;

/**
 * 
 * @author SJ
 * 
 */
public interface CalculationService {
	public void insertTestData();

	public List<CalculationVO> getList(CalculationVO menu);

	public int count(CalculationVO menu);

	public CalculationVO getDetail(CalculationVO menu);

	public int insertAction(CalculationVO menu);

	public int updateCalculationIschecked(CalculationVO calculation);

	public int updateCalculationIsimportant(CalculationVO calculation);

	public List<CalculationVO> getReservationList(CalculationVO calculation);

	public List<CalculationVO> getCustomerRequestList(CalculationVO calculation);
}