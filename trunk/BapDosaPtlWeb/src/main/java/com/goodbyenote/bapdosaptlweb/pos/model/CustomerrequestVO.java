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
@Table(name = "CUSTOMERREQUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customerrequest.findAll", query = "SELECT c FROM Customerrequest c")})
public class CustomerrequestVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomerrequestPK customerrequestPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "CONTENTS")
    private String contents;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISDEFAULT")
    private Character isdefault;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private int orderid;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public CustomerrequestVO() {
    }

    public CustomerrequestVO(CustomerrequestPK customerrequestPK) {
        this.customerrequestPK = customerrequestPK;
    }

    public CustomerrequestVO(CustomerrequestPK customerrequestPK, String contents, Character isdefault, int orderid) {
        this.customerrequestPK = customerrequestPK;
        this.contents = contents;
        this.isdefault = isdefault;
        this.orderid = orderid;
    }

    public CustomerrequestVO(int memberid, int deviceid, int requestid) {
        this.customerrequestPK = new CustomerrequestPK(memberid, deviceid, requestid);
    }

    public CustomerrequestPK getCustomerrequestPK() {
        return customerrequestPK;
    }

    public void setCustomerrequestPK(CustomerrequestPK customerrequestPK) {
        this.customerrequestPK = customerrequestPK;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
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
        hash += (customerrequestPK != null ? customerrequestPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerrequestVO)) {
            return false;
        }
        CustomerrequestVO other = (CustomerrequestVO) object;
        if ((this.customerrequestPK == null && other.customerrequestPK != null) || (this.customerrequestPK != null && !this.customerrequestPK.equals(other.customerrequestPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Customerrequest[ customerrequestPK=" + customerrequestPK + " ]";
    }
    
}
