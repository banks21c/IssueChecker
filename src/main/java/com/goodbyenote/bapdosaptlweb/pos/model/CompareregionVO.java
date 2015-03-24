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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "COMPAREREGION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compareregion.findAll", query = "SELECT c FROM Compareregion c")})
public class CompareregionVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompareregionPK compareregionPK;
    @Column(name = "COMPAREREGIONID")
    private int compareregionid;

    public CompareregionVO() {
    }

    public CompareregionVO(CompareregionPK compareregionPK) {
        this.compareregionPK = compareregionPK;
    }

    public CompareregionVO(int buildingid, int deviceid, int memberid) {
        this.compareregionPK = new CompareregionPK(buildingid, deviceid, memberid);
    }

    public CompareregionPK getCompareregionPK() {
        return compareregionPK;
    }

    public void setCompareregionPK(CompareregionPK compareregionPK) {
        this.compareregionPK = compareregionPK;
    }

    public int getCompareregionid() {
        return compareregionid;
    }

    public void setCompareregionid(int compareregionid) {
        this.compareregionid = compareregionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compareregionPK != null ? compareregionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompareregionVO)) {
            return false;
        }
        CompareregionVO other = (CompareregionVO) object;
        if ((this.compareregionPK == null && other.compareregionPK != null) || (this.compareregionPK != null && !this.compareregionPK.equals(other.compareregionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Compareregion[ compareregionPK=" + compareregionPK + " ]";
    }
    
}
