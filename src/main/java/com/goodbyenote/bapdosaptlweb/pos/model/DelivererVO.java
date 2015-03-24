/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodbyenote.bapdosaptlweb.pos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "DELIVERER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliverer.findAll", query = "SELECT d FROM Deliverer d")})
public class DelivererVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DelivererPK delivererPK;
    @Size(max = 18)
    @Column(name = "DELIVERERNAME")
    private String deliverername;
    @Size(max = 18)
    @Column(name = "DELIVERERPHONENUMBER")
    private String delivererphonenumber;
    @Size(max = 18)
    @Column(name = "CREATIONDATE")
    private String creationdate;
    @Size(max = 18)
    @Column(name = "MODIFICATIONDATE")
    private String modificationdate;

    public DelivererVO() {
    }

    public DelivererVO(DelivererPK delivererPK) {
        this.delivererPK = delivererPK;
    }

    public DelivererVO(int memberid, int deviceid, int delivererid) {
        this.delivererPK = new DelivererPK(memberid, deviceid, delivererid);
    }

    public DelivererPK getDelivererPK() {
        return delivererPK;
    }

    public void setDelivererPK(DelivererPK delivererPK) {
        this.delivererPK = delivererPK;
    }

    public String getDeliverername() {
        return deliverername;
    }

    public void setDeliverername(String deliverername) {
        this.deliverername = deliverername;
    }

    public String getDelivererphonenumber() {
        return delivererphonenumber;
    }

    public void setDelivererphonenumber(String delivererphonenumber) {
        this.delivererphonenumber = delivererphonenumber;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    public String getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(String modificationdate) {
        this.modificationdate = modificationdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (delivererPK != null ? delivererPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DelivererVO)) {
            return false;
        }
        DelivererVO other = (DelivererVO) object;
        if ((this.delivererPK == null && other.delivererPK != null) || (this.delivererPK != null && !this.delivererPK.equals(other.delivererPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Deliverer[ delivererPK=" + delivererPK + " ]";
    }
    
}
