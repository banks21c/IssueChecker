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
public class DeliveryrecordVO extends PosCommonVO implements Serializable {
    private static final long serialVersionUID = 1L;
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
}
