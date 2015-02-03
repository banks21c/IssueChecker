package com.goodbyenote.bapdosaptlweb.pos.model;

import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class CustomerVO {
	/**
     * 주문 내역 유형
     * 0 : 매장고객(default)
     * 1 : 배달고객
     */
    public enum CustomerType {
        Hall("매장고객"),
        Takeout("배달고객");

        private String span;
        private static final Map<Integer, CustomerType> lookup = new HashMap<Integer, CustomerType>();

        static {
            int ordinal = 0;
            for (CustomerType type : EnumSet.allOf(CustomerType.class)) {
                lookup.put(ordinal, type);
                ordinal +=1;
            }
        }

        public static CustomerType fromOrdinal(int ordinal) {
            return lookup.get(ordinal);
        }

        CustomerType(String str) {
            span = str;
        }

        public String getSpan() {
            return span;
        }
    }

    /**
     * 1.단골 아이디
     */
    public int CustomerId;
    /**
     * 2.단골 이름
     */
    public String Name;
    /**
     * 3.고객타입 : 매장고객/배달고객
     */
    //public CustomerType Type; --> IsDelivery
    /**
     * 4.전화번호
     */
    public String PhoneNumber;
    /**
     * 4.보조 전화번호
     */
    public String PhoneNumber2;
    /**
     * 4.단골 주소
     */
    public String Addr;
    /**
     * 5.단골 총 매상
     */
    public int TotalSales;
    public int TotalCredit;
    public int TotalDeposit;
    /**
     * 6.단골 선결제
     */
    public int EarlyCredit;
    /**
     * 7.단골 현재외상
     */
    public int CurrCredit;
    /**
     * 8.단골 일회성 여부
     */
    public char IsInstant;
    public char IsBlack;
    public char IsDelivery;
    /**
     * 9.단골 사용 가능 여부
     */
    public char IsDeleted;
    public Date CreationDate;
    /**
     * 10.수정 일자
     */
    public Date MDate;

    /**
     * 11.동기화 일자
     */
    public Date SDate;

    public int BuildingId;
}
