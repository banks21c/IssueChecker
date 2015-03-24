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
@Table(name = "TRADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trade.findAll", query = "SELECT t FROM Trade t")})
public class TradeVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TradePK tradePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRADETYPE")
    private int tradetype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private int orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYMASTERID")
    private int deliverymasterid;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public TradeVO() {
    }

    public TradeVO(TradePK tradePK) {
        this.tradePK = tradePK;
    }

    public TradeVO(TradePK tradePK, int tradetype, int price, int orderid, int deliverymasterid) {
        this.tradePK = tradePK;
        this.tradetype = tradetype;
        this.price = price;
        this.orderid = orderid;
        this.deliverymasterid = deliverymasterid;
    }

    public TradeVO(int memberid, int deviceid, int tradeid) {
        this.tradePK = new TradePK(memberid, deviceid, tradeid);
    }

    public TradePK getTradePK() {
        return tradePK;
    }

    public void setTradePK(TradePK tradePK) {
        this.tradePK = tradePK;
    }

    public int getTradetype() {
        return tradetype;
    }

    public void setTradetype(int tradetype) {
        this.tradetype = tradetype;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getDeliverymasterid() {
        return deliverymasterid;
    }

    public void setDeliverymasterid(int deliverymasterid) {
        this.deliverymasterid = deliverymasterid;
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
        hash += (tradePK != null ? tradePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradeVO)) {
            return false;
        }
        TradeVO other = (TradeVO) object;
        if ((this.tradePK == null && other.tradePK != null) || (this.tradePK != null && !this.tradePK.equals(other.tradePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Trade[ tradePK=" + tradePK + " ]";
    }
    
}
