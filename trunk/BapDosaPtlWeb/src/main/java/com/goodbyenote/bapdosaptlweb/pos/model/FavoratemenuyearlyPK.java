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
public class FavoratemenuyearlyPK implements Serializable {
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
    @Column(name = "MEMUID")
    private int memuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "YEAR")
    private String year;

    public FavoratemenuyearlyPK() {
    }

    public FavoratemenuyearlyPK(int memberid, int deviceid, int memuid, String year) {
        this.memberid = memberid;
        this.deviceid = deviceid;
        this.memuid = memuid;
        this.year = year;
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

    public int getMemuid() {
        return memuid;
    }

    public void setMemuid(int memuid) {
        this.memuid = memuid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.FavoratemenuyearlyPK[ memberid=" + memberid + ", deviceid=" + deviceid + ", memuid=" + memuid + ", year=" + year + " ]";
    }
    
}
