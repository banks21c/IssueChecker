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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "ORDERDETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM Orderdetail o")})
public class OrderdetailVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderdetailPK orderdetailPK;
    @Column(name = "TABLEID")
    private int tableid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMUID")
    private int memuid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISTAKEOUT")
    private Character istakeout;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
    @Column(name = "ISSERVICE")
    private Character isservice;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public OrderdetailVO() {
    }

    public OrderdetailVO(OrderdetailPK orderdetailPK) {
        this.orderdetailPK = orderdetailPK;
    }

    public OrderdetailVO(OrderdetailPK orderdetailPK, int memuid, int amount, Character istakeout, int price) {
        this.orderdetailPK = orderdetailPK;
        this.memuid = memuid;
        this.amount = amount;
        this.istakeout = istakeout;
        this.price = price;
    }

    public OrderdetailVO(int memberid, int deviceid, int orderdetailid, int orderid) {
        this.orderdetailPK = new OrderdetailPK(memberid, deviceid, orderdetailid, orderid);
    }

    public OrderdetailPK getOrderdetailPK() {
        return orderdetailPK;
    }

    public void setOrderdetailPK(OrderdetailPK orderdetailPK) {
        this.orderdetailPK = orderdetailPK;
    }

    public int getTableid() {
        return tableid;
    }

    public void setTableid(int tableid) {
        this.tableid = tableid;
    }

    public int getMemuid() {
        return memuid;
    }

    public void setMemuid(int memuid) {
        this.memuid = memuid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Character getIstakeout() {
        return istakeout;
    }

    public void setIstakeout(Character istakeout) {
        this.istakeout = istakeout;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Character getIsservice() {
        return isservice;
    }

    public void setIsservice(Character isservice) {
        this.isservice = isservice;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderdetailPK != null ? orderdetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderdetailVO)) {
            return false;
        }
        OrderdetailVO other = (OrderdetailVO) object;
        if ((this.orderdetailPK == null && other.orderdetailPK != null) || (this.orderdetailPK != null && !this.orderdetailPK.equals(other.orderdetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Orderdetail[ orderdetailPK=" + orderdetailPK + " ]";
    }
    
}
