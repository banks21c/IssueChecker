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
	public List<Map> getCategoryList(Map searchCondition) {
		return sqlSession.selectList("category.getCategoryList", searchCondition);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryJsonList(Map searchCondition) {
		return sqlSession.selectList("category.getCategoryJsonList", searchCondition);
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
	public List<Map> getCategoryMenuList(Map searchCondition) {
		return sqlSession.selectList("category.getCategoryMenuList", searchCondition);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryMenuJsonList(Map searchCondition) {
		return sqlSession.selectList("category.getCategoryMenuJsonList", searchCondition);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryPointList(Map searchCondition) {
		return sqlSession.selectList("category.getCategoryPointList", searchCondition);
	}

	public List<CategoryVO> getList(CategoryVO category) {
		return sqlSession.selectList("category.getList", category);
	}

	public int count(CategoryVO category) {
		return (Integer) sqlSession.selectOne("category.count", category);
	}

	public List<Map<String, ?>> listExcel(CategoryVO category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map> listExcel2(CategoryVO category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CategoryVO> detailList(CategoryVO category) {
		return null;
	}

	public CategoryVO getDetailSum(CategoryVO category) {
		return (CategoryVO) sqlSession.selectOne("category.getViewData", category);
	}

	public CategoryVO view(CategoryVO category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CategoryVO> viewDtl(CategoryVO category) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertAction(CategoryVO category) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertDtlAction(CategoryVO category) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateAction(CategoryVO category) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteDtlAction(CategoryVO category) {
		// TODO Auto-generated method stub
		return 0;

	}

	public int deleteAction(CategoryVO category) {
		// TODO Auto-generated method stub
		return 0;
	}

	public CategoryVO viewDtlSum(CategoryVO category) {
		// TODO Auto-generated method stub
		return null;
	}

	public CategoryVO getDetail(CategoryVO category) {
		return (CategoryVO) sqlSession.selectOne("category.getDetail", category);

	}

	public int updateCategoryIschecked(CategoryVO category) {
		return sqlSession.update("category.updateCategoryIschecked", category);
	}

	public int updateCategoryIsimportant(CategoryVO category) {
		return sqlSession.update("category.updateCategoryIsimportant", category);
	}

	public List<CategoryVO> getReservationList(CategoryVO category) {
		return sqlSession.selectList("category.getReservationList", category);
	}

	public List<CategoryVO> getCustomerRequestList(CategoryVO category) {
		return sqlSession.selectList("category.getCustomerRequestList", category);
	}
}
