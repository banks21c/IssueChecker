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
@Table(name = "DELIVERYORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliveryorder.findAll", query = "SELECT d FROM Deliveryorder d")})
public class DeliveryorderVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeliveryorderPK deliveryorderPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYMASTERID")
    private int deliverymasterid;
    @Column(name = "MEMUID")
    private int memuid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public DeliveryorderVO() {
    }

    public DeliveryorderVO(DeliveryorderPK deliveryorderPK) {
        this.deliveryorderPK = deliveryorderPK;
    }

    public DeliveryorderVO(DeliveryorderPK deliveryorderPK, int amount, int deliverymasterid, int price) {
        this.deliveryorderPK = deliveryorderPK;
        this.amount = amount;
        this.deliverymasterid = deliverymasterid;
        this.price = price;
    }

    public DeliveryorderVO(int memberid, int deviceid, int deliveryorderid) {
        this.deliveryorderPK = new DeliveryorderPK(memberid, deviceid, deliveryorderid);
    }

    public DeliveryorderPK getDeliveryorderPK() {
        return deliveryorderPK;
    }

    public void setDeliveryorderPK(DeliveryorderPK deliveryorderPK) {
        this.deliveryorderPK = deliveryorderPK;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDeliverymasterid() {
        return deliverymasterid;
    }

    public void setDeliverymasterid(int deliverymasterid) {
        this.deliverymasterid = deliverymasterid;
    }

    public int getMemuid() {
        return memuid;
    }

    public void setMemuid(int memuid) {
        this.memuid = memuid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        hash += (deliveryorderPK != null ? deliveryorderPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliveryorderVO)) {
            return false;
        }
        DeliveryorderVO other = (DeliveryorderVO) object;
        if ((this.deliveryorderPK == null && other.deliveryorderPK != null) || (this.deliveryorderPK != null && !this.deliveryorderPK.equals(other.deliveryorderPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Deliveryorder[ deliveryorderPK=" + deliveryorderPK + " ]";
    }
    
}
