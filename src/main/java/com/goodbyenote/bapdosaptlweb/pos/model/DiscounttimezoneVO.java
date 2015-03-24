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
@Table(name = "DISCOUNTTIMEZONE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discounttimezone.findAll", query = "SELECT d FROM Discounttimezone d")})
public class DiscounttimezoneVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiscounttimezonePK discounttimezonePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENDTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public DiscounttimezoneVO() {
    }

    public DiscounttimezoneVO(DiscounttimezonePK discounttimezonePK) {
        this.discounttimezonePK = discounttimezonePK;
    }

    public DiscounttimezoneVO(DiscounttimezonePK discounttimezonePK, Date starttime, Date endtime) {
        this.discounttimezonePK = discounttimezonePK;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public DiscounttimezoneVO(String memberid, String deviceid, String weekday) {
        this.discounttimezonePK = new DiscounttimezonePK(memberid, deviceid, weekday);
    }

    public DiscounttimezonePK getDiscounttimezonePK() {
        return discounttimezonePK;
    }

    public void setDiscounttimezonePK(DiscounttimezonePK discounttimezonePK) {
        this.discounttimezonePK = discounttimezonePK;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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
        hash += (discounttimezonePK != null ? discounttimezonePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscounttimezoneVO)) {
            return false;
        }
        DiscounttimezoneVO other = (DiscounttimezoneVO) object;
        if ((this.discounttimezonePK == null && other.discounttimezonePK != null) || (this.discounttimezonePK != null && !this.discounttimezonePK.equals(other.discounttimezonePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Discounttimezone[ discounttimezonePK=" + discounttimezonePK + " ]";
    }
    
}
