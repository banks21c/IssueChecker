package com.goodbyenote.issuechecker.pos.category.service;

import java.util.List;
import java.util.Map;

import com.goodbyenote.issuechecker.common.model.SessionUserInfo;
import com.goodbyenote.issuechecker.pos.model.CategoryVO;

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
	
	public void updateMenuDiffer(Map parametaMap);
	
	public void updateDcDiffer(Map parametaMap);
	
	public void updateDcPointChoice(Map parametaMap);
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryMenuList(Map parametaMap);
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryMenuJsonList(Map parametaMap);
	
	@SuppressWarnings("rawtypes")
	public List<Map> getCategoryPointList(Map searchCondition);
	
	public Map getMenuDiffer(Map parametaMap);
	
	public List<Map> getDcDiffer(Map parametaMap);
	
	public Map getDcPointChoice(Map parametaMap);
	
	public int menuSave(Map<String, Object> menuObjMap,
			SessionUserInfo sessionUserInfo);

}