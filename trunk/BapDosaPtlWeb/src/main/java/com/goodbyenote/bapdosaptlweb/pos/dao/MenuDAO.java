package com.goodbyenote.bapdosaptlweb.pos.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodbyenote.bapdosaptlweb.pos.model.MenuVO;

@Repository
public class MenuDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertTestData() {
		List<MenuVO> menus = new ArrayList<MenuVO>(13);
		Date date = new Date();

        String[] cook_menus = {
                "눈꽃살",
                "생갈비",
                "안창살",
                "눈꽃등심",
                "특수부위모듬",
                "양념갈비",
                "육회 대",
                "육회 소",
                "육사시미",
                "석쇠양녕구이",
                "차돌박이"
        };

        int[] cook_price = {
                55000,
                55000,
                55000,
                45000,
                38000,
                36000,
                35000,
                25000,
                35000,
                28000,
                25000
        };

        String[] meal_menus = {
                "차돌박이 대",
                "차돌박이 중",
                "양념버섯불고기",
                "한우갈비양곰탕",
                "한우갈비탕",
                "뚝배기불고기",
                "국수전골",
                "돌솥비빔밥",
                "육회비빔밤",
                "차돌된장찌개",
                "물냉면",
                "비빔냉면",
                "생불고기",
                "사골우거지탕",
                "해물순두부",
                "육개장",
                "코다리회냉면"
        };

        int[] meal_price = {
                50000,
                30000,
                18000,
                15000,
                13000,
                8000,
                10000,
                8000,
                9000,
                6000,
                7000,
                7000,
                20000,
                7000,
                7000,
                8000,
                8000
        };

        String[] alchol_menus = {
                "참이슬",
                "맥주",
                "막걸리",
                "한라산",
                "매화수",
                "백세주",
                "복분자",
        };

        int[] alchol_price = {
                3000,
                4000,
                3000,
                4000,
                4000,
                7000,
                10000
        };

        String[] drink_menus = {
                "아메리카노",
                "카페라떼",
                "카프치노",
                "카페모카",
                "카라멜마끼아또",
                "페퍼민트",
                "카모마일",
                "자스민",
        };

        int[] drink_price = {
                3000,
                3000,
                3000,
                3000,
                4000,
                3000,
                3000,
                3000,
        };


        String[] special_menus = {
                "점심특선1",
                "점심특선2",
                "점심특선3",
                "점심특선4",
                "점심특선5",
        };

        String[] combo_menus = {
                "세트메뉴1",
                "세트메뉴2",
                "세트메뉴3",
                "세트메뉴4",
                "세트메뉴5",
        };


        String[] discount_menus = {
                "할인메뉴1",
                "할인메뉴2",
                "할인메뉴3",
                "할인메뉴4",
                "할인메뉴5"
        };

        String[] takeout_menus = {
                "포장메뉴1",
                "포장메뉴2",
                "포장메뉴3",
                "포장메뉴4",
                "포장메뉴5"
        };

        String[] service_menus = {
                "서비스메뉴1",
                "서비스메뉴2",
                "서비스메뉴3",
                "서비스메뉴4",
                "서비스메뉴5",
                "서비스메뉴6"
        };

        int i = 0;
        int menuId = 1;
        for (String name : cook_menus) {
            MenuVO item = new MenuVO();
            item.MenuId = menuId ++;
            item.Name = name;
            item.DefaultPrice = cook_price[i];
            item.StorePrice = cook_price[i];
            item.TakeoutPrice = cook_price[i];
            item.DeliveryPrice = cook_price[i];
            item.CategoryId = 1;
            item.SortOrder = i;
            item.CreationDate = date;
            item.MDate = date;
            menus.add(item);

            i++;
        }

        i = 0;
        for (String name : meal_menus) {
            MenuVO item = new MenuVO();
            item.MenuId = menuId ++;
            item.Name = name;
            item.DefaultPrice = meal_price[i];
            item.StorePrice = meal_price[i];
            item.TakeoutPrice = meal_price[i];
            item.DeliveryPrice = meal_price[i];
            item.CategoryId = 2;
            item.SortOrder = i;
            item.CreationDate = date;
            item.MDate = date;
            menus.add(item);

            i++;
        }

        i = 0;
        for (String name : alchol_menus) {
            MenuVO item = new MenuVO();
            item.MenuId = menuId ++;
            item.Name = name;
            item.DefaultPrice = alchol_price[i];
            item.StorePrice = alchol_price[i];
            item.TakeoutPrice = alchol_price[i];
            item.DeliveryPrice = alchol_price[i];
            item.CategoryId = 3;
            item.SortOrder = i;
            item.CreationDate = date;
            item.MDate = date;
            menus.add(item);

            i++;
        }

        i = 0;
        for (String name : drink_menus) {
            MenuVO item = new MenuVO();
            item.MenuId = menuId ++;
            item.Name = name;
            item.DefaultPrice = drink_price[i];
            item.StorePrice = drink_price[i];
            item.TakeoutPrice = drink_price[i];
            item.DeliveryPrice = drink_price[i];
            item.CategoryId = 4;
            item.SortOrder = i;
            item.CreationDate = date;
            item.MDate = date;
            menus.add(item);

            i++;
        }

        i = 0;
        for (String name : special_menus) {
            MenuVO item = new MenuVO();
            item.MenuId = menuId ++;
            item.Name = name;
            item.DefaultPrice = 5000;
            item.StorePrice = 5000;
            item.TakeoutPrice = 5000;
            item.DeliveryPrice = 5000;
            item.CategoryId = 6;
            item.SortOrder = i;
            item.CreationDate = date;
            item.MDate = date;
            menus.add(item);

            i++;
        }

        i = 0;
        for (String name : combo_menus) {
            MenuVO item = new MenuVO();
            item.MenuId = menuId ++;
            item.Name = name;
            item.DefaultPrice = 10000;
            item.StorePrice = 10000;
            item.TakeoutPrice = 10000;
            item.DeliveryPrice = 10000;
            item.CategoryId = 7;
            item.SortOrder = i;
            item.CreationDate = date;
            item.MDate = date;
            menus.add(item);
            i++;
        }

        i = 0;
        for (String name : discount_menus) {
            MenuVO item = new MenuVO();
            item.MenuId = menuId ++;
            item.Name = name;
            item.DefaultPrice = 10000;
            item.StorePrice = 10000;
            item.TakeoutPrice = 10000;
            item.DeliveryPrice = 10000;
            item.CategoryId = 8;
            item.SortOrder = i;
            item.CreationDate = date;
            item.MDate = date;
            menus.add(item);
            i++;
        }

        i = 0;
        for (String name : takeout_menus) {
            MenuVO item = new MenuVO();
            item.MenuId = menuId ++;
            item.Name = name;
            item.DefaultPrice = 10000;
            item.StorePrice = 10000;
            item.TakeoutPrice = 10000;
            item.DeliveryPrice = 10000;
            item.CategoryId = 9;
            item.SortOrder = i;
            item.CreationDate = date;
            item.MDate = date;
            menus.add(item);
            i++;
        }

        i = 0;
        for (String name : service_menus) {
            MenuVO item = new MenuVO();
            item.MenuId = menuId ++;
            item.Name = name;
            item.DefaultPrice = 0;
            item.StorePrice = 0;
            item.TakeoutPrice = 0;
            item.DeliveryPrice = 0;
            item.CategoryId = 10;
            item.SortOrder = i;
            item.CreationDate = date;
            item.MDate = date;
            menus.add(item);
            i++;
        }
        
        for(MenuVO m : menus){
        	sqlSession.insert("pos.insertMenu", m);	
        }
	}
}
