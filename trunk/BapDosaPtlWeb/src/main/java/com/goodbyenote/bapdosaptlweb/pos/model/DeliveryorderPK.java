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
public class DeliveryorderPK implements Serializable {
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
    @Column(name = "DELIVERYORDERID")
    private int deliveryorderid;

    public DeliveryorderPK() {
    }

    public DeliveryorderPK(int memberid, int deviceid, int deliveryorderid) {
        this.memberid = memberid;
        this.deviceid = deviceid;
        this.deliveryorderid = deliveryorderid;
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

    public int getDeliveryorderid() {
        return deliveryorderid;
    }

    public void setDeliveryorderid(int deliveryorderid) {
        this.deliveryorderid = deliveryorderid;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.DeliveryorderPK[ memberid=" + memberid + ", deviceid=" + deviceid + ", deliveryorderid=" + deliveryorderid + " ]";
    }
    
}
