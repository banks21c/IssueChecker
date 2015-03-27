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

	public List<CategoryVO> getList(CategoryVO category) {
		return sqlSession.selectList("CategoryMapper.getList", category);
	}

	public int count(CategoryVO category) {
		return (Integer) sqlSession.selectOne("CategoryMapper.count", category);
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
		return (CategoryVO) sqlSession.selectOne("CategoryMapper.getViewData", category);
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
		return (CategoryVO) sqlSession.selectOne("CategoryMapper.getDetail", category);

	}

	public int updateCategoryIschecked(CategoryVO category) {
		return sqlSession.update("CategoryMapper.updateCategoryIschecked", category);
	}

	public int updateCategoryIsimportant(CategoryVO category) {
		return sqlSession.update("CategoryMapper.updateCategoryIsimportant", category);
	}

	public List<CategoryVO> getReservationList(CategoryVO category) {
		return sqlSession.selectList("CategoryMapper.getReservationList", category);
	}

	public List<CategoryVO> getCustomerRequestList(CategoryVO category) {
		return sqlSession.selectList("CategoryMapper.getCustomerRequestList", category);
	}
}
