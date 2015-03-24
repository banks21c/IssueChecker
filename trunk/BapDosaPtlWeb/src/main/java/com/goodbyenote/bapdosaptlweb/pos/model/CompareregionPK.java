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
public class CompareregionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUILDINGID")
    private int buildingid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEVICEID")
    private int deviceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBERID")
    private int memberid;

    public CompareregionPK() {
    }

    public CompareregionPK(int buildingid, int deviceid, int memberid) {
        this.buildingid = buildingid;
        this.deviceid = deviceid;
        this.memberid = memberid;
    }

    public int getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(int buildingid) {
        this.buildingid = buildingid;
    }

    public int getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(int deviceid) {
        this.deviceid = deviceid;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.CompareregionPK[ buildingid=" + buildingid + ", deviceid=" + deviceid + ", memberid=" + memberid + " ]";
    }
    
}
