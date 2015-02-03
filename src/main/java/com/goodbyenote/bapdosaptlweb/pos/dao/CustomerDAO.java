package com.goodbyenote.bapdosaptlweb.pos.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.bapdosaptlweb.pos.model.CustomerVO;
import com.goodbyenote.bapdosaptlweb.pos.model.MenuVO;

@Repository
public class CustomerDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<MenuVO> getMenus() {
		return sqlSession.selectList("common.getMenus");
	}
	
	public void insertTestData() {	
		Date date = new Date();
		
		String[] names = {"정대리", "정차장", "고대리", "최과장", "조이사"};
		String[] numbers = {"01038294857", "01038102857", "01038789857", "01045694857", "01038294123"};
		int[] sales = {57, 2857, 9857, 94857, 8294123};
		int[] buildings = {57, 2857, 9857, 94857, 8294123};
		String[] addr = {"정대리주소", "정차장주소", "고대리주소", "최과장주소", "조이사주소"};
	        
		 for(int i = 0; i < 5; i++ ) {
	        CustomerVO regular = new CustomerVO();
	        regular.CustomerId = i + 1;
		    regular.Name = names[i];
		    regular.PhoneNumber = numbers[i];
		    regular.TotalSales = sales[i];
		    regular.IsInstant = 'N';
		    regular.TotalCredit = 0;
		    regular.TotalDeposit = 0;
		    regular.IsDelivery = 'N';
		    regular.PhoneNumber2 = "";
		    regular.BuildingId = buildings[i];
		    regular.Addr = addr[i];
		    regular.IsBlack = 'N';
		    regular.IsDeleted = 'N';
		    regular.CreationDate = date;
		    regular.MDate = date;
		  
	        sqlSession.insert("pos.insertCustomerData", regular);
		 }
	}	
}
