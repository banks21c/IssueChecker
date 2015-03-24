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
public class DeliveryrecordPK implements Serializable {
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
    @Column(name = "DELIVERYMASTERID")
    private int deliverymasterid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYRECORDID")
    private int deliveryrecordid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERERID")
    private int delivererid;

    public DeliveryrecordPK() {
    }

    public DeliveryrecordPK(int memberid, int deviceid, int deliverymasterid, int deliveryrecordid, int delivererid) {
        this.memberid = memberid;
        this.deviceid = deviceid;
        this.deliverymasterid = deliverymasterid;
        this.deliveryrecordid = deliveryrecordid;
        this.delivererid = delivererid;
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

    public int getDeliverymasterid() {
        return deliverymasterid;
    }

    public void setDeliverymasterid(int deliverymasterid) {
        this.deliverymasterid = deliverymasterid;
    }

    public int getDeliveryrecordid() {
        return deliveryrecordid;
    }

    public void setDeliveryrecordid(int deliveryrecordid) {
        this.deliveryrecordid = deliveryrecordid;
    }

    public int getDelivererid() {
        return delivererid;
    }

    public void setDelivererid(int delivererid) {
        this.delivererid = delivererid;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.DeliveryrecordPK[ memberid=" + memberid + ", deviceid=" + deviceid + ", deliverymasterid=" + deliverymasterid + ", deliveryrecordid=" + deliveryrecordid + ", delivererid=" + delivererid + " ]";
    }
    
}
