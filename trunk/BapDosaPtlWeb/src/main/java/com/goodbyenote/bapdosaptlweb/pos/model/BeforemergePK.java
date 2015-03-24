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

/**
 *
 * @author David
 */
@Embeddable
public class BeforemergePK implements Serializable {
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

    public BeforemergePK() {
    }

    public BeforemergePK(int memberid, int deviceid, int orderid, int beforemergeid) {
        this.memberid = memberid;
        this.deviceid = deviceid;
        this.orderid = orderid;
        this.beforemergeid = beforemergeid;
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

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.BeforemergePK[ memberid=" + memberid + ", deviceid=" + deviceid + ", orderid=" + orderid + ", beforemergeid=" + beforemergeid + " ]";
    }
    
}
