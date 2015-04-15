package com.goodbyenote.bapdosaptlweb.pos.category.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.pos.category.dao.CategoryDAO;
import com.goodbyenote.bapdosaptlweb.pos.category.service.CategoryService;
import com.goodbyenote.bapdosaptlweb.pos.model.CategoryVO;

/**
 * 
 * @author SJ
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	CategoryDAO categoryDAO;

	/**
	 * TEST 용도 데이터 삽입
	 */
	@Override
	public void insertTestData(){ 
		logger.info("test test insertTestData");
		//customerDAO.insertTestData();		
		//memberDAO.insertTestData();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getCategoryList(Map searchCondition) {
		return categoryDAO.getCategoryList(searchCondition);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getCategoryJsonList(Map searchCondition) {
		return categoryDAO.getCategoryJsonList(searchCondition);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void insertCategory(Map parametaMap) {
		// TODO Auto-generated method stub
		categoryDAO.insertCategory(parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void updateCategory(Map parametaMap) {
		// TODO Auto-generated method stub
		categoryDAO.updateCategory(parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getCategoryMenuList(Map searchCondition) {
		return categoryDAO.getCategoryMenuList(searchCondition);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getCategoryMenuJsonList(Map searchCondition) {
		return categoryDAO.getCategoryMenuJsonList(searchCondition);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getCategoryPointList(Map searchCondition) {
		return categoryDAO.getCategoryPointList(searchCondition);
	}

	@Override
	public List<CategoryVO> getList(CategoryVO category) {
		return categoryDAO.getList(category);
	}

	@Override
	public int count(CategoryVO category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CategoryVO getDetail(CategoryVO category) {
		return categoryDAO.getDetail(category);
	}

	@Override
	public int insertAction(CategoryVO category) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int updateCategoryIschecked(CategoryVO category){
		return categoryDAO.updateCategoryIschecked(category);
	}
	public int updateCategoryIsimportant(CategoryVO category){
		return categoryDAO.updateCategoryIsimportant(category);
	}

	@Override
	public List<CategoryVO> getReservationList(CategoryVO category) {
		return categoryDAO.getReservationList(category);
	}

	@Override
	public List<CategoryVO> getCustomerRequestList(CategoryVO category) {
		return categoryDAO.getCustomerRequestList(category);
	}

}