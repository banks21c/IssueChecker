package com.goodbyenote.bapdosaptlweb.pos.model;

import java.util.Date;

public class CustomerRequestVO {
	/**
     * 고객 요구사항 id
     */
    public long RequestId;
    /**
     * 고객 요구사항 내용
     */
    public String Contents;
    /**
     * 기본으로? (리스트로?)
     */
    public boolean IsDefault;
    /**
     * 주문 id
     */
    public long OrderId;
    /**
     * 사용가능 여부
     */
    public boolean IsDeleted;
    /**
     * 생성일자
     */
    public Date CreationDate;
    /**
     * 수정일자
     */
    public Date ModificationDate;
    /**
     * 동기화 일자
     */
    public Date SyncDate;
    /**
     * 선택 여부
     */
    public boolean Toggle;
}
