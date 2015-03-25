/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodbyenote.bapdosaptlweb.pos.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author David
 */
@Embeddable
public class PosCommonVO implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBERID")
    private int memberid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEVICEID")
    private int deviceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private int orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BEFOREMERGEID")
    private int beforemergeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUILDINGID")
    private int buildingid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORYID")
    private int categoryid;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "YEAR")
    private String year;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "MONTH")
    private String month;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQUESTID")
    private int requestid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERTRADEID")
    private int customertradeid;    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERERID")
    private int delivererid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYMASTERID")
    private int deliverymasterid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYORDERID")
    private int deliveryorderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYRECORDID")
    private int deliveryrecordid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "WEEKDAY")
    private String weekday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMUID")
    private int memuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "STARTSALESDATE")
    private String startsalesdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "HOUR")
    private String hour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "YEARMONTH")
    private String yearmonth;    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERDETAILID")
    private int orderdetailid;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TABLEID")
    private int tableid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POINTID")
    private int pointid;

    @Basic(optional = false)
    @NotNull
    @Column(name = "RESERVID")
    private int reservid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRADEID")
    private int tradeid;
    private String code;
    private String codeName;
    
    public PosCommonVO() {
    }

    public PosCommonVO(int memberid, int deviceid) {
        this.memberid = memberid;
        this.deviceid = deviceid;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public int getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(int deviceid) {
        this.deviceid = deviceid;
    }


    public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getBeforemergeid() {
		return beforemergeid;
	}

	public void setBeforemergeid(int beforemergeid) {
		this.beforemergeid = beforemergeid;
	}

	public int getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(int buildingid) {
		this.buildingid = buildingid;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public int getCustomertradeid() {
		return customertradeid;
	}

	public void setCustomertradeid(int customertradeid) {
		this.customertradeid = customertradeid;
	}

	public int getDelivererid() {
		return delivererid;
	}

	public void setDelivererid(int delivererid) {
		this.delivererid = delivererid;
	}

	public int getDeliverymasterid() {
		return deliverymasterid;
	}

	public void setDeliverymasterid(int deliverymasterid) {
		this.deliverymasterid = deliverymasterid;
	}

	public int getDeliveryorderid() {
		return deliveryorderid;
	}

	public void setDeliveryorderid(int deliveryorderid) {
		this.deliveryorderid = deliveryorderid;
	}

	public int getDeliveryrecordid() {
		return deliveryrecordid;
	}

	public void setDeliveryrecordid(int deliveryrecordid) {
		this.deliveryrecordid = deliveryrecordid;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public int getMemuid() {
		return memuid;
	}

	public void setMemuid(int memuid) {
		this.memuid = memuid;
	}

	public String getStartsalesdate() {
		return startsalesdate;
	}

	public void setStartsalesdate(String startsalesdate) {
		this.startsalesdate = startsalesdate;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
	}

	public int getOrderdetailid() {
		return orderdetailid;
	}

	public void setOrderdetailid(int orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

	public int getTableid() {
		return tableid;
	}

	public void setTableid(int tableid) {
		this.tableid = tableid;
	}

	public int getPointid() {
		return pointid;
	}

	public void setPointid(int pointid) {
		this.pointid = pointid;
	}

	public int getReservid() {
		return reservid;
	}

	public void setReservid(int reservid) {
		this.reservid = reservid;
	}

	public int getTradeid() {
		return tradeid;
	}

	public void setTradeid(int tradeid) {
		this.tradeid = tradeid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

}
