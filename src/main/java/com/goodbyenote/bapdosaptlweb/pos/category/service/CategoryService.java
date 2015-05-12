package com.goodbyenote.bapdosaptlweb.pos.category.service;

import java.util.List;
import java.util.Map;

import com.goodbyenote.bapdosaptlweb.common.model.SessionUserInfo;
import com.goodbyenote.bapdosaptlweb.pos.model.CategoryVO;

/**
 * 
 * @author SJ
 * 
 */
public interface CategoryService {
	public void insertTestData();
	//public List<CategoryVO> getCategoryList(CategoryVO category);
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryList(Map parametaMap);
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryJsonList(Map searchCondition);
	
	public void insertCategory(Map parametaMap);
	
	public void updateCategory(Map parametaMap);
	
	public void insertCateMenu(Map parametaMap);
	
	public void updateCateMenu(Map parametaMap);
	
	public void updateCatePoint(Map parametaMap);
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryMenuList(Map parametaMap);
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryMenuJsonList(Map parametaMap);
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryPointList(Map searchCondition);
	
	@SuppressWarnings("rawtypes")
	List<Map> getDcTimeList(Map parametaMap);
	
	public void updateDcMenu(Map parametaMap);
	
	public int menuSave(Map<String, Object> menuObjMap,
			SessionUserInfo sessionUserInfo);

	public List<CategoryVO> getList(CategoryVO menu);

	public int count(CategoryVO menu);

	public CategoryVO getDetail(CategoryVO menu);

	public int insertAction(CategoryVO menu);

	public int updateCategoryIschecked(CategoryVO category);

	public int updateCategoryIsimportant(CategoryVO category);

	public List<CategoryVO> getReservationList(CategoryVO category);

	public List<CategoryVO> getCustomerRequestList(CategoryVO category);
}