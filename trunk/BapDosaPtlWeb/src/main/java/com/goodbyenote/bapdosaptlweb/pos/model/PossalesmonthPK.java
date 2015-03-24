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
public class PossalesmonthPK implements Serializable {
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
    @Size(min = 1, max = 18)
    @Column(name = "YEARMONTH")
    private String yearmonth;

    public PossalesmonthPK() {
    }

    public PossalesmonthPK(int memberid, int deviceid, String yearmonth) {
        this.memberid = memberid;
        this.deviceid = deviceid;
        this.yearmonth = yearmonth;
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

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.PossalesmonthPK[ memberid=" + memberid + ", deviceid=" + deviceid + ", yearmonth=" + yearmonth + " ]";
    }
    
}
