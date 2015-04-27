package com.goodbyenote.bapdosaptlweb.pos.category.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodbyenote.bapdosaptlweb.common.model.SessionUserInfo;
import com.goodbyenote.bapdosaptlweb.common.util.DateUtil;
import com.goodbyenote.bapdosaptlweb.common.util.SecurityUtils;
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
	public List<Map> getCategoryList(Map parametaMap) {
		return categoryDAO.getCategoryList(parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getCategoryJsonList(Map parametaMap) {
		return categoryDAO.getCategoryJsonList(parametaMap);
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
	public void insertCateMenu(Map parametaMap) {
		// TODO Auto-generated method stub
		categoryDAO.insertCateMenu(parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void updateCateMenu(Map parametaMap) {
		// TODO Auto-generated method stub
		categoryDAO.updateCateMenu(parametaMap);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void updateCatePoint(Map parametaMap) {
		// TODO Auto-generated method stub
		categoryDAO.updateCatePoint(parametaMap);
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
	public int menuSave(Map<String, Object> menuObjMap,
			SessionUserInfo sessionUserInfo) {
		// TODO Auto-generated method stub
		
		String categoryid = (String)menuObjMap.get("categoryid");
		String menuid = (String)menuObjMap.get("menuid");
		

		
		if("".equals(menuid)){
			
			menuid = SecurityUtils.getTimeFormatUnique();	
			//String startsalesdate = DateUtil.getFormatStrFromDate(DateUtil.getDateAdd(new Date(), "h", -6), "YYYYMMdd");
			
			Map paramMap = new HashMap();
			paramMap.put("memberid", sessionUserInfo.getMemberId());
			paramMap.put("deviceid", sessionUserInfo.getDeviceId());
			paramMap.put("categoryid", categoryid);	
			paramMap.put("price", 0);
//			paramMap.put("givebackcredit", null);
//			paramMap.put("loss", null);
//			paramMap.put("discount", null);
//			paramMap.put("billmoney", null);
//			paramMap.put("cashpayment", null);
//			paramMap.put("cardpayment", null);
//			paramMap.put("intocredit", null);
//			paramMap.put("intoloss", null);
//			paramMap.put("intodeposit", null);
//			paramMap.put("usedticket", null);
//			paramMap.put("savedpoint", null);
//			paramMap.put("useddeposit", null);
//			paramMap.put("usedpoint", null);
//			paramMap.put("ischangeaftermerge", null);
			
			System.out.println(paramMap);
			categoryDAO.insertCateMenu(paramMap);			
		} 

				
		
		List<Map> menuDataList = (List<Map>)menuObjMap.get("menuDataList");
		menuDataList.forEach( 
			menuData -> {
				System.out.println(menuData);	
				
				menuData.put("memberid", sessionUserInfo.getMemberId());
				menuData.put("deviceid", sessionUserInfo.getDeviceId());				
				menuData.put("categoryid", (String)menuObjMap.get("categoryid"));
				menuData.put("sortorder", (String)menuObjMap.get("sortorder"));
				
				categoryDAO.updateCateMenu(menuData);
				
				/*String orderDetailId = (String)orderData.get("orderDetailId");
				String newFlag = (String)orderData.get("newFlag");
				if("Y".equals(newFlag) && "".equals(orderDetailId)){
					orderData.put("orderDetailId", SecurityUtils.getTimeFormatUnique());
					
					System.out.println(orderData);
					orderDAO.insertOrderDetail(orderData);
				}
				else {
					Map selMap = orderDAO.selectOrderDetail(orderData);
					
					if(selMap != null){
						orderDAO.updateOrderDetail(orderData);
					}
					
				}*/
				
			}
		);
				
		return 1;
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