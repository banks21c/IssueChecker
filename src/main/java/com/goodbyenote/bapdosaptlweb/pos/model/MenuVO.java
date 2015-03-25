/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodbyenote.bapdosaptlweb.pos.model;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")})
public class MenuVO extends PosCommonVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MENUID")
    private int menuid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORYID")
    private int categoryid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SORTORDER")
    private int sortorder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEFAULTPRICE")
    private int defaultprice;
    @Column(name = "STOREPRICE")
    private int storeprice;
    @Column(name = "DELIVERYPRICE")
    private int deliveryprice;
    @Column(name = "TAKEOUTPRICE")
    private int takeoutprice;
    @Column(name = "DEFAULTPOINT")
    private int defaultpoint;
    @Column(name = "STOREPOINT")
    private int storepoint;
    @Column(name = "DELIVERYPOINT")
    private int deliverypoint;
    @Column(name = "TAKEOUTPOINT")
    private int takeoutpoint;
    @Column(name = "DEFAULTDISCOUNT")
    private int defaultdiscount;
    @Column(name = "STOREDISCOUNT")
    private int storediscount;
    @Column(name = "DELIVERYDISCOUNT")
    private int deliverydiscount;
    @Column(name = "TAKEOUTDISCOUNT")
    private int takeoutdiscount;
    @Column(name = "ISHIDDEN")
    private Character ishidden;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;
    @Column(name = "SYNCDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date syncdate;
    @Column(name = "ISDELETED")
    private Character isdeleted;

    public MenuVO() {
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSortorder() {
        return sortorder;
    }

    public void setSortorder(int sortorder) {
        this.sortorder = sortorder;
    }

    public int getDefaultprice() {
        return defaultprice;
    }

    public void setDefaultprice(int defaultprice) {
        this.defaultprice = defaultprice;
    }

    public int getStoreprice() {
        return storeprice;
    }

    public void setStoreprice(int storeprice) {
        this.storeprice = storeprice;
    }

    public int getDeliveryprice() {
        return deliveryprice;
    }

    public void setDeliveryprice(int deliveryprice) {
        this.deliveryprice = deliveryprice;
    }

    public int getTakeoutprice() {
        return takeoutprice;
    }

    public void setTakeoutprice(int takeoutprice) {
        this.takeoutprice = takeoutprice;
    }

    public int getDefaultpoint() {
        return defaultpoint;
    }

    public void setDefaultpoint(int defaultpoint) {
        this.defaultpoint = defaultpoint;
    }

    public int getStorepoint() {
        return storepoint;
    }

    public void setStorepoint(int storepoint) {
        this.storepoint = storepoint;
    }

    public int getDeliverypoint() {
        return deliverypoint;
    }

    public void setDeliverypoint(int deliverypoint) {
        this.deliverypoint = deliverypoint;
    }

    public int getTakeoutpoint() {
        return takeoutpoint;
    }

    public void setTakeoutpoint(int takeoutpoint) {
        this.takeoutpoint = takeoutpoint;
    }

    public int getDefaultdiscount() {
        return defaultdiscount;
    }

    public void setDefaultdiscount(int defaultdiscount) {
        this.defaultdiscount = defaultdiscount;
    }

    public int getStorediscount() {
        return storediscount;
    }

    public void setStorediscount(int storediscount) {
        this.storediscount = storediscount;
    }

    public int getDeliverydiscount() {
        return deliverydiscount;
    }

    public void setDeliverydiscount(int deliverydiscount) {
        this.deliverydiscount = deliverydiscount;
    }

    public int getTakeoutdiscount() {
        return takeoutdiscount;
    }

    public void setTakeoutdiscount(int takeoutdiscount) {
        this.takeoutdiscount = takeoutdiscount;
    }

    public Character getIshidden() {
        return ishidden;
    }

    public void setIshidden(Character ishidden) {
        this.ishidden = ishidden;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    public Date getSyncdate() {
        return syncdate;
    }

    public void setSyncdate(Date syncdate) {
        this.syncdate = syncdate;
    }

    public Character getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Character isdeleted) {
        this.isdeleted = isdeleted;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }
    
}
