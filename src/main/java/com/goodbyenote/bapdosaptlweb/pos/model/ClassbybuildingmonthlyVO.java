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
@Table(name = "CLASSBYBUILDINGMONTHLY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classbybuildingmonthly.findAll", query = "SELECT c FROM Classbybuildingmonthly c")})
public class ClassbybuildingmonthlyVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClassbybuildingmonthlyPK classbybuildingmonthlyPK;
    @Size(max = 18)
    @Column(name = "SALESAMOUNT")
    private String salesamount;
    @Size(max = 18)
    @Column(name = "CREATIONDATE")
    private String creationdate;
    @Size(max = 18)
    @Column(name = "MODIFICATIONDATE")
    private String modificationdate;

    public ClassbybuildingmonthlyVO() {
    }

    public ClassbybuildingmonthlyVO(ClassbybuildingmonthlyPK classbybuildingmonthlyPK) {
        this.classbybuildingmonthlyPK = classbybuildingmonthlyPK;
    }

    public ClassbybuildingmonthlyVO(int memberid, int deviceid, int buildingid, String year, String month) {
        this.classbybuildingmonthlyPK = new ClassbybuildingmonthlyPK(memberid, deviceid, buildingid, year, month);
    }

    public ClassbybuildingmonthlyPK getClassbybuildingmonthlyPK() {
        return classbybuildingmonthlyPK;
    }

    public void setClassbybuildingmonthlyPK(ClassbybuildingmonthlyPK classbybuildingmonthlyPK) {
        this.classbybuildingmonthlyPK = classbybuildingmonthlyPK;
    }

    public String getSalesamount() {
        return salesamount;
    }

    public void setSalesamount(String salesamount) {
        this.salesamount = salesamount;
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
        hash += (classbybuildingmonthlyPK != null ? classbybuildingmonthlyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassbybuildingmonthlyVO)) {
            return false;
        }
        ClassbybuildingmonthlyVO other = (ClassbybuildingmonthlyVO) object;
        if ((this.classbybuildingmonthlyPK == null && other.classbybuildingmonthlyPK != null) || (this.classbybuildingmonthlyPK != null && !this.classbybuildingmonthlyPK.equals(other.classbybuildingmonthlyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Classbybuildingmonthly[ classbybuildingmonthlyPK=" + classbybuildingmonthlyPK + " ]";
    }
    
}
