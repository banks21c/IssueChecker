package com.goodbyenote.bapdosaptlweb.pos.category.service;

import java.util.List;

import com.goodbyenote.bapdosaptlweb.pos.model.CategoryVO;

/**
 * 
 * @author SJ
 * 
 */
public interface CategoryService {
	public void insertTestData();

	public List<CategoryVO> getList(CategoryVO menu);

	public int count(CategoryVO menu);

	public CategoryVO getDetail(CategoryVO menu);

	public int insertAction(CategoryVO menu);

	public int updateCategoryIschecked(CategoryVO category);

	public int updateCategoryIsimportant(CategoryVO category);

	public List<CategoryVO> getReservationList(CategoryVO category);

	public List<CategoryVO> getCustomerRequestList(CategoryVO category);
}