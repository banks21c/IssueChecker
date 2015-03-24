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
@Table(name = "POINT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Point.findAll", query = "SELECT p FROM Point p")})
public class PointVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PointPK pointPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POINTTYPE")
    private int pointtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private int orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYMASTERID")
    private int deliverymasterid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALPOINT")
    private int totalpoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USEDPOINT")
    private int usedpoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REMAINPOINT")
    private int remainpoint;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public PointVO() {
    }

    public PointVO(PointPK pointPK) {
        this.pointPK = pointPK;
    }

    public PointVO(PointPK pointPK, int customerid, int pointtype, int orderid, int deliverymasterid, int totalpoint, int usedpoint, int remainpoint) {
        this.pointPK = pointPK;
        this.customerid = customerid;
        this.pointtype = pointtype;
        this.orderid = orderid;
        this.deliverymasterid = deliverymasterid;
        this.totalpoint = totalpoint;
        this.usedpoint = usedpoint;
        this.remainpoint = remainpoint;
    }

    public PointVO(int memberid, int deviceid, int pointid) {
        this.pointPK = new PointPK(memberid, deviceid, pointid);
    }

    public PointPK getPointPK() {
        return pointPK;
    }

    public void setPointPK(PointPK pointPK) {
        this.pointPK = pointPK;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getPointtype() {
        return pointtype;
    }

    public void setPointtype(int pointtype) {
        this.pointtype = pointtype;
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

    public int getTotalpoint() {
        return totalpoint;
    }

    public void setTotalpoint(int totalpoint) {
        this.totalpoint = totalpoint;
    }

    public int getUsedpoint() {
        return usedpoint;
    }

    public void setUsedpoint(int usedpoint) {
        this.usedpoint = usedpoint;
    }

    public int getRemainpoint() {
        return remainpoint;
    }

    public void setRemainpoint(int remainpoint) {
        this.remainpoint = remainpoint;
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
        hash += (pointPK != null ? pointPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PointVO)) {
            return false;
        }
        PointVO other = (PointVO) object;
        if ((this.pointPK == null && other.pointPK != null) || (this.pointPK != null && !this.pointPK.equals(other.pointPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Point[ pointPK=" + pointPK + " ]";
    }
    
}
