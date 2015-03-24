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
public class ClassbybuildingmonthlyPK implements Serializable {
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
    @Column(name = "BUILDINGID")
    private int buildingid;
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

    public ClassbybuildingmonthlyPK() {
    }

    public ClassbybuildingmonthlyPK(int memberid, int deviceid, int buildingid, String year, String month) {
        this.memberid = memberid;
        this.deviceid = deviceid;
        this.buildingid = buildingid;
        this.year = year;
        this.month = month;
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

    public int getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(int buildingid) {
        this.buildingid = buildingid;
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

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.ClassbybuildingmonthlyPK[ memberid=" + memberid + ", deviceid=" + deviceid + ", buildingid=" + buildingid + ", year=" + year + ", month=" + month + " ]";
    }
    
}
