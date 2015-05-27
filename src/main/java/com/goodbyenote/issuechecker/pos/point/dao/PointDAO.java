package com.goodbyenote.issuechecker.pos.point.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.issuechecker.pos.model.PointVO;

@Repository
public class PointDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertTestData() {
		List<PointVO> menus = new ArrayList<PointVO>(13);

		for (PointVO m : menus) {
			sqlSession.insert("pos.insertPoint", m);
		}
	}

	public List<PointVO> getList(PointVO point) {
		return sqlSession.selectList("PointMapper.getList", point);
	}

	public int count(PointVO point) {
		return (Integer) sqlSession.selectOne("PointMapper.count", point);
	}

	public List<Map<String, ?>> listExcel(PointVO point) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map> listExcel2(PointVO point) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PointVO> detailList(PointVO point) {
		return null;
	}

	public PointVO getDetailSum(PointVO point) {
		return (PointVO) sqlSession.selectOne("PointMapper.getViewData", point);
	}

	public PointVO view(PointVO point) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PointVO> viewDtl(PointVO point) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertAction(PointVO point) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertDtlAction(PointVO point) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateAction(PointVO point) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteDtlAction(PointVO point) {
		// TODO Auto-generated method stub
		return 0;

	}

	public int deleteAction(PointVO point) {
		// TODO Auto-generated method stub
		return 0;
	}

	public PointVO viewDtlSum(PointVO point) {
		// TODO Auto-generated method stub
		return null;
	}

	public PointVO getDetail(PointVO point) {
		return (PointVO) sqlSession.selectOne("PointMapper.getDetail", point);

	}

	public int updatePointIschecked(PointVO point) {
		return sqlSession.update("PointMapper.updatePointIschecked", point);
	}

	public int updatePointIsimportant(PointVO point) {
		return sqlSession.update("PointMapper.updatePointIsimportant", point);
	}

	public List<PointVO> getReservationList(PointVO point) {
		return sqlSession.selectList("PointMapper.getReservationList", point);
	}

	public List<PointVO> getCustomerRequestList(PointVO point) {
		return sqlSession.selectList("PointMapper.getCustomerRequestList", point);
	}
}
