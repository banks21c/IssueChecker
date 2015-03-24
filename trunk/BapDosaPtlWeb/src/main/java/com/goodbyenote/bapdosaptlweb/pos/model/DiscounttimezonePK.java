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
public class DiscounttimezonePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "MEMBERID")
    private String memberid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "DEVICEID")
    private String deviceid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "WEEKDAY")
    private String weekday;

    public DiscounttimezonePK() {
    }

    public DiscounttimezonePK(String memberid, String deviceid, String weekday) {
        this.memberid = memberid;
        this.deviceid = deviceid;
        this.weekday = weekday;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberid != null ? memberid.hashCode() : 0);
        hash += (deviceid != null ? deviceid.hashCode() : 0);
        hash += (weekday != null ? weekday.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscounttimezonePK)) {
            return false;
        }
        DiscounttimezonePK other = (DiscounttimezonePK) object;
        if ((this.memberid == null && other.memberid != null) || (this.memberid != null && !this.memberid.equals(other.memberid))) {
            return false;
        }
        if ((this.deviceid == null && other.deviceid != null) || (this.deviceid != null && !this.deviceid.equals(other.deviceid))) {
            return false;
        }
        if ((this.weekday == null && other.weekday != null) || (this.weekday != null && !this.weekday.equals(other.weekday))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.DiscounttimezonePK[ memberid=" + memberid + ", deviceid=" + deviceid + ", weekday=" + weekday + " ]";
    }
    
}
