package com.goodbyenote.issuechecker.pos.calculation.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.issuechecker.pos.model.CalculationVO;

@Repository
public class CalculationDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertTestData() {
		List<CalculationVO> menus = new ArrayList<CalculationVO>(13);

		for (CalculationVO m : menus) {
			sqlSession.insert("pos.insertCalculation", m);
		}
	}

	public List<CalculationVO> getList(CalculationVO calculation) {
		return sqlSession.selectList("CalculationMapper.getList", calculation);
	}

	public int count(CalculationVO calculation) {
		return (Integer) sqlSession.selectOne("CalculationMapper.count", calculation);
	}

	public List<Map<String, ?>> listExcel(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map> listExcel2(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CalculationVO> detailList(CalculationVO calculation) {
		return null;
	}

	public CalculationVO getDetailSum(CalculationVO calculation) {
		return (CalculationVO) sqlSession.selectOne("CalculationMapper.getViewData", calculation);
	}

	public CalculationVO view(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CalculationVO> viewDtl(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertAction(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertDtlAction(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateAction(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteDtlAction(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return 0;

	}

	public int deleteAction(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return 0;
	}

	public CalculationVO viewDtlSum(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return null;
	}

	public CalculationVO getDetail(CalculationVO calculation) {
		return (CalculationVO) sqlSession.selectOne("CalculationMapper.getDetail", calculation);

	}

	public int updateCalculationIschecked(CalculationVO calculation) {
		return sqlSession.update("CalculationMapper.updateCalculationIschecked", calculation);
	}

	public int updateCalculationIsimportant(CalculationVO calculation) {
		return sqlSession.update("CalculationMapper.updateCalculationIsimportant", calculation);
	}

	public List<CalculationVO> getReservationList(CalculationVO calculation) {
		return sqlSession.selectList("CalculationMapper.getReservationList", calculation);
	}

	public List<CalculationVO> getCustomerRequestList(CalculationVO calculation) {
		return sqlSession.selectList("CalculationMapper.getCustomerRequestList", calculation);
	}

	public int updateCaculationIschecked(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateCaculationIsimportant(CalculationVO calculation) {
		// TODO Auto-generated method stub
		return 0;
	}
}
