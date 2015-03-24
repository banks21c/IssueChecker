/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodbyenote.bapdosaptlweb.pos.model;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "BEFOREMERGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beforemerge.findAll", query = "SELECT b FROM Beforemerge b")})
public class BeforemergeVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BeforemergePK beforemergePK;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public BeforemergeVO() {
    }

    public BeforemergeVO(BeforemergePK beforemergePK) {
        this.beforemergePK = beforemergePK;
    }

    public BeforemergeVO(int memberid, int deviceid, int orderid, int beforemergeid) {
        this.beforemergePK = new BeforemergePK(memberid, deviceid, orderid, beforemergeid);
    }

    public BeforemergePK getBeforemergePK() {
        return beforemergePK;
    }

    public void setBeforemergePK(BeforemergePK beforemergePK) {
        this.beforemergePK = beforemergePK;
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
        hash += (beforemergePK != null ? beforemergePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeforemergeVO)) {
            return false;
        }
        BeforemergeVO other = (BeforemergeVO) object;
        if ((this.beforemergePK == null && other.beforemergePK != null) || (this.beforemergePK != null && !this.beforemergePK.equals(other.beforemergePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Beforemerge[ beforemergePK=" + beforemergePK + " ]";
    }
    
}
