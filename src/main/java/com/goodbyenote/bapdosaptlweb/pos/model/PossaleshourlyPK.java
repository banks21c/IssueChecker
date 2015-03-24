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
public class PossaleshourlyPK implements Serializable {
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
    @Size(min = 1, max = 8)
    @Column(name = "STARTSALESDATE")
    private String startsalesdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "HOUR")
    private String hour;

    public PossaleshourlyPK() {
    }

    public PossaleshourlyPK(int memberid, int deviceid, String startsalesdate, String hour) {
        this.memberid = memberid;
        this.deviceid = deviceid;
        this.startsalesdate = startsalesdate;
        this.hour = hour;
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

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.PossaleshourlyPK[ memberid=" + memberid + ", deviceid=" + deviceid + ", startsalesdate=" + startsalesdate + ", hour=" + hour + " ]";
    }
    
}
