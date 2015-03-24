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
@Table(name = "DELIVERYRECORD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliveryrecord.findAll", query = "SELECT d FROM Deliveryrecord d")})
public class DeliveryrecordVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeliveryrecordPK deliveryrecordPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTSALESDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startsalesdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYTYPE")
    private int deliverytype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYORDER")
    private int deliveryorder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYSTATUS")
    private int deliverystatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISBYBOSS")
    private Character isbyboss;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public DeliveryrecordVO() {
    }

    public DeliveryrecordVO(DeliveryrecordPK deliveryrecordPK) {
        this.deliveryrecordPK = deliveryrecordPK;
    }

    public DeliveryrecordVO(DeliveryrecordPK deliveryrecordPK, Date startsalesdate, int deliverytype, int deliveryorder, int deliverystatus, Character isbyboss) {
        this.deliveryrecordPK = deliveryrecordPK;
        this.startsalesdate = startsalesdate;
        this.deliverytype = deliverytype;
        this.deliveryorder = deliveryorder;
        this.deliverystatus = deliverystatus;
        this.isbyboss = isbyboss;
    }

    public DeliveryrecordVO(int memberid, int deviceid, int deliverymasterid, int deliveryrecordid, int delivererid) {
        this.deliveryrecordPK = new DeliveryrecordPK(memberid, deviceid, deliverymasterid, deliveryrecordid, delivererid);
    }

    public DeliveryrecordPK getDeliveryrecordPK() {
        return deliveryrecordPK;
    }

    public void setDeliveryrecordPK(DeliveryrecordPK deliveryrecordPK) {
        this.deliveryrecordPK = deliveryrecordPK;
    }

    public Date getStartsalesdate() {
        return startsalesdate;
    }

    public void setStartsalesdate(Date startsalesdate) {
        this.startsalesdate = startsalesdate;
    }

    public int getDeliverytype() {
        return deliverytype;
    }

    public void setDeliverytype(int deliverytype) {
        this.deliverytype = deliverytype;
    }

    public int getDeliveryorder() {
        return deliveryorder;
    }

    public void setDeliveryorder(int deliveryorder) {
        this.deliveryorder = deliveryorder;
    }

    public int getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(int deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public Character getIsbyboss() {
        return isbyboss;
    }

    public void setIsbyboss(Character isbyboss) {
        this.isbyboss = isbyboss;
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
        hash += (deliveryrecordPK != null ? deliveryrecordPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliveryrecordVO)) {
            return false;
        }
        DeliveryrecordVO other = (DeliveryrecordVO) object;
        if ((this.deliveryrecordPK == null && other.deliveryrecordPK != null) || (this.deliveryrecordPK != null && !this.deliveryrecordPK.equals(other.deliveryrecordPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Deliveryrecord[ deliveryrecordPK=" + deliveryrecordPK + " ]";
    }
    
}
