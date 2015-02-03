package com.goodbyenote.bapdosaptlweb.pos.model;

import java.util.Date;

public class MemberDriverVO {
	/**
     * 배달원 Id
     */
    public int MemberDriverId;
    /**
     * 이름
     */
    public String Name;
    /**
     * 연락처
     */
    public String PhoneNumber;
    /**
     * 사용 가능 여부
     */
    public boolean IsDeleted;
    /**
     *
     */
    public Date CreationDate;
    /**
     * 수정 일시
     */
    public Date ModificationDate;

    /**
     * 동기화 일시
     */
    public Date SyncDate;
}
