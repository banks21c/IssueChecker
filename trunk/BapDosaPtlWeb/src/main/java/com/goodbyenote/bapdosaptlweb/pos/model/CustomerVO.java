/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodbyenote.bapdosaptlweb.pos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

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
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerVO.findAll", query = "SELECT c FROM CustomerVO c")})
public class CustomerVO implements Serializable {
	
	/**
     * 주문 내역 유형
     * 0 : 매장고객(default)
     * 1 : 배달고객
     */
    public enum CustomerType {
        Hall("매장고객"),
        Takeout("배달고객");

        private String span;
        private static final Map<Integer, CustomerType> lookup = new HashMap<Integer, CustomerType>();

        static {
            int ordinal = 0;
            for (CustomerType type : EnumSet.allOf(CustomerType.class)) {
                lookup.put(ordinal, type);
                ordinal +=1;
            }
        }

        public static CustomerType fromOrdinal(int ordinal) {
            return lookup.get(ordinal);
        }

        CustomerType(String str) {
            span = str;
        }

        public String getSpan() {
            return span;
        }
    }
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomerPK customerPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALSALES")
    private int totalsales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISINSTANT")
    private Character isinstant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALCREDIT")
    private int totalcredit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALDEPOSIT")
    private int totaldeposit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISBLACK")
    private int isblack;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISDELIVER")
    private int isdeliver;
    @Basic(optional = false)
    @Null
    @Column(name = "ISDELETED")    
    private int isdeleted;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "PHONENUMBER2")
    private String phonenumber2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUILDINGID")
    private int buildingid;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public CustomerVO() {
    }

    public CustomerVO(CustomerPK customerPK) {
        this.customerPK = customerPK;
    }

    public CustomerVO(CustomerPK customerPK, String name, String phonenumber, int totalsales, Character isinstant, int totalcredit, int totaldeposit, String address, int isblack, int isdeliver, String phonenumber2, int buildingid) {
        this.customerPK = customerPK;
        this.name = name;
        this.phonenumber = phonenumber;
        this.totalsales = totalsales;
        this.isinstant = isinstant;
        this.totalcredit = totalcredit;
        this.totaldeposit = totaldeposit;
        this.address = address;
        this.isblack = isblack;
        this.isdeliver = isdeliver;
        this.phonenumber2 = phonenumber2;
        this.buildingid = buildingid;
    }

    public CustomerVO(int deviceid, int memberid, int customerid) {
        this.customerPK = new CustomerPK(deviceid, memberid, customerid);
    }

    public CustomerPK getCustomerPK() {
        return customerPK;
    }

    public void setCustomerPK(CustomerPK customerPK) {
        this.customerPK = customerPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getTotalsales() {
        return totalsales;
    }

    public void setTotalsales(int totalsales) {
        this.totalsales = totalsales;
    }

    public Character getIsinstant() {
        return isinstant;
    }

    public void setIsinstant(Character isinstant) {
        this.isinstant = isinstant;
    }

    public int getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(int isdeleted) {
		this.isdeleted = isdeleted;
	}

	public int getTotalcredit() {
        return totalcredit;
    }

    public void setTotalcredit(int totalcredit) {
        this.totalcredit = totalcredit;
    }

    public int getTotaldeposit() {
        return totaldeposit;
    }

    public void setTotaldeposit(int totaldeposit) {
        this.totaldeposit = totaldeposit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsblack() {
        return isblack;
    }

    public void setIsblack(int isblack) {
        this.isblack = isblack;
    }

    public int getIsdeliver() {
        return isdeliver;
    }

    public void setIsdeliver(int isdeliver) {
        this.isdeliver = isdeliver;
    }

    public String getPhonenumber2() {
        return phonenumber2;
    }

    public void setPhonenumber2(String phonenumber2) {
        this.phonenumber2 = phonenumber2;
    }

    public int getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(int buildingid) {
        this.buildingid = buildingid;
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
        hash += (customerPK != null ? customerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerVO)) {
            return false;
        }
        CustomerVO other = (CustomerVO) object;
        if ((this.customerPK == null && other.customerPK != null) || (this.customerPK != null && !this.customerPK.equals(other.customerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.CustomerVO[ customerPK=" + customerPK + " ]";
    }
    
}
