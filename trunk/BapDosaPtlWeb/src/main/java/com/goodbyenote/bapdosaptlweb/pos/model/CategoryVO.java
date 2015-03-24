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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")})
public class CategoryVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CategoryPK categoryPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private int orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISETC")
    private Character isetc;
    @Column(name = "ISSERVICE")
    private Character isservice;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public CategoryVO() {
    }

    public CategoryVO(CategoryPK categoryPK) {
        this.categoryPK = categoryPK;
    }

    public CategoryVO(CategoryPK categoryPK, String name, int orderid, Character isetc) {
        this.categoryPK = categoryPK;
        this.name = name;
        this.orderid = orderid;
        this.isetc = isetc;
    }

    public CategoryVO(String memberid, String deviceid, int categoryid) {
        this.categoryPK = new CategoryPK(memberid, deviceid, categoryid);
    }

    public CategoryPK getCategoryPK() {
        return categoryPK;
    }

    public void setCategoryPK(CategoryPK categoryPK) {
        this.categoryPK = categoryPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Character getIsetc() {
        return isetc;
    }

    public void setIsetc(Character isetc) {
        this.isetc = isetc;
    }

    public Character getIsservice() {
        return isservice;
    }

    public void setIsservice(Character isservice) {
        this.isservice = isservice;
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
        hash += (categoryPK != null ? categoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryVO)) {
            return false;
        }
        CategoryVO other = (CategoryVO) object;
        if ((this.categoryPK == null && other.categoryPK != null) || (this.categoryPK != null && !this.categoryPK.equals(other.categoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Category[ categoryPK=" + categoryPK + " ]";
    }
    
}
