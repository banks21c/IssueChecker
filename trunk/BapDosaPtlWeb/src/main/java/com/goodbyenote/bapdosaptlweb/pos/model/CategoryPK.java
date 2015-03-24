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
public class CategoryPK implements Serializable {
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
    @Column(name = "CATEGORYID")
    private int categoryid;

    public CategoryPK() {
    }

    public CategoryPK(String memberid, String deviceid, int categoryid) {
        this.memberid = memberid;
        this.deviceid = deviceid;
        this.categoryid = categoryid;
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

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

 
    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.CategoryPK[ memberid=" + memberid + ", deviceid=" + deviceid + ", categoryid=" + categoryid + " ]";
    }
    
}
