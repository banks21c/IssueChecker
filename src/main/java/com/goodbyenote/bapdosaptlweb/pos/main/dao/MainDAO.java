package com.goodbyenote.bapdosaptlweb.pos.main.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.bapdosaptlweb.pos.model.MainVO;

@Repository
public class MainDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertTestData() {
		List<MainVO> menus = new ArrayList<MainVO>(13);

		for (MainVO m : menus) {
			sqlSession.insert("pos.insertMain", m);
		}
	}

	public List<MainVO> getList(MainVO main) {
		return sqlSession.selectList("MainMapper.getList", main);
	}

	public int count(MainVO main) {
		return (Integer) sqlSession.selectOne("MainMapper.count", main);
	}

	public List<Map<String, ?>> listExcel(MainVO main) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map> listExcel2(MainVO main) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MainVO> detailList(MainVO main) {
		return null;
	}

	public MainVO getDetailSum(MainVO main) {
		return (MainVO) sqlSession.selectOne("MainMapper.getViewData", main);
	}

	public MainVO view(MainVO main) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MainVO> viewDtl(MainVO main) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertAction(MainVO main) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertDtlAction(MainVO main) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateAction(MainVO main) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteDtlAction(MainVO main) {
		// TODO Auto-generated method stub
		return 0;

	}

	public int deleteAction(MainVO main) {
		// TODO Auto-generated method stub
		return 0;
	}

	public MainVO viewDtlSum(MainVO main) {
		// TODO Auto-generated method stub
		return null;
	}

	public MainVO getDetail(MainVO main) {
		return (MainVO) sqlSession.selectOne("MainMapper.getDetail", main);

	}

	public int updateMainIschecked(MainVO main) {
		return sqlSession.update("MainMapper.updateMainIschecked", main);
	}

	public int updateMainIsimportant(MainVO main) {
		return sqlSession.update("MainMapper.updateMainIsimportant", main);
	}
}
