package com.goodbyenote.bapdosaptlweb.pos.category.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.bapdosaptlweb.pos.model.CategoryVO;

@Repository
public class CategoryDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertTestData() {
		List<CategoryVO> menus = new ArrayList<CategoryVO>(13);

		for (CategoryVO m : menus) {
			sqlSession.insert("pos.insertCategory", m);
		}
	}
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryList(Map parametaMap) {
		return sqlSession.selectList("category.getCategoryList", parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryJsonList(Map parametaMap) {
		return sqlSession.selectList("category.getCategoryJsonList", parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	public int insertCategory(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.insert("category.insertCategory", parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	public int updateCategory(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.update("category.updateCategory", parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	public int insertCateMenu(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.insert("category.insertCateMenu", parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	public int updateCateMenu(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.update("category.updateCateMenu", parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	public int updateCatePoint(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.update("category.updateCatePoint", parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	public int updateMenuDiffer(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.update("category.updateMenuDiffer", parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	public int updateDcDiffer(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.update("category.updateDcDiffer", parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	public int updateDcPointChoice(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.update("category.updateDcPointChoice", parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryMenuList(Map parametaMap) {
		return sqlSession.selectList("category.getCategoryMenuList", parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryMenuJsonList(Map searchCondition) {
		return sqlSession.selectList("category.getCategoryMenuJsonList", searchCondition);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryPointList(Map searchCondition) {
		return sqlSession.selectList("category.getCategoryPointList", searchCondition);
	}
	
	public Map getMenuDiffer(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("category.getMenuDiffer", parametaMap);
	}
	
	public Map getDcDiffer(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("category.getDcDiffer", parametaMap);
	}
	
	public Map getDcPointChoice(Map parametaMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("category.getDcPointChoice", parametaMap);
	}

}
