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
public class OrderdetailPK implements Serializable {
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
    @Column(name = "ORDERDETAILID")
    private int orderdetailid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private int orderid;

    public OrderdetailPK() {
    }

    public OrderdetailPK(int memberid, int deviceid, int orderdetailid, int orderid) {
        this.memberid = memberid;
        this.deviceid = deviceid;
        this.orderdetailid = orderdetailid;
        this.orderid = orderid;
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

    public int getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(int orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.OrderdetailPK[ memberid=" + memberid + ", deviceid=" + deviceid + ", orderdetailid=" + orderdetailid + ", orderid=" + orderid + " ]";
    }
    
}
