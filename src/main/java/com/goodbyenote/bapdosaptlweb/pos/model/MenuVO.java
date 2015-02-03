package com.goodbyenote.bapdosaptlweb.pos.model;

import java.util.Date;

public class MenuVO {
	/**
     * 1. 메뉴 아이디
     */
    public long MenuId;
    /**
     * 2. 소속카테고리 아이디
     */
    public long CategoryId;
    /**
     * 3. 메뉴명
     */
    public String Name;
    /**
     * 4. 정렬 순서 (화면에서의 순서)
      */
    public int SortOrder;
    /**
     * 5. 금액
     */
    public int DefaultPrice;
    public int StorePrice;
    public int DeliveryPrice;
    public int TakeoutPrice;
    /**
     * 6. 포인트
     */
    public int DefaultPoint;
    public int StorePoint;
    public int DeliveryPoint;
    public int TakeoutPoint;
    /**
     * 할인
     */
    public int DefaultDiscount;
    public int StoreDiscount;
    public int DeliveryDiscount;
    public int TakeoutDiscount;
    /**
     * 7. 숨김여부
     */
    public boolean IsHidden;
    /**
     * 생성 날짜
     */
    public Date CreationDate;
    /**
     * 수정 날짜
     */
    public Date MDate;
    /**
     * 9. 동기화 날짜
     */
    public Date SDate;
    /**
     * 10. 사용여부
     */
    public boolean IsDeleted;
}
