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
@Table(name = "CUSTOMERTRADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customertrade.findAll", query = "SELECT c FROM Customertrade c")})
public class CustomertradeVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomertradePK customertradePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "STARTSALESDATE")
    private String startsalesdate;
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Column(name = "TRADEID")
    private int tradeid;
    @Column(name = "DELIVERYMASTERID")
    private int deliverymasterid;
    @Size(max = 18)
    @Column(name = "CONTENTS")
    private String contents;
    @Column(name = "BILL")
    private int bill;
    @Column(name = "PAYMENT")
    private int payment;
    @Column(name = "CREDIT")
    private int credit;
    @Column(name = "TOTALDEPOSIT")
    private int totaldeposit;
    @Column(name = "TOTALCREDIT")
    private int totalcredit;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public CustomertradeVO() {
    }

    public CustomertradeVO(CustomertradePK customertradePK) {
        this.customertradePK = customertradePK;
    }

    public CustomertradeVO(CustomertradePK customertradePK, String startsalesdate) {
        this.customertradePK = customertradePK;
        this.startsalesdate = startsalesdate;
    }

    public CustomertradeVO(int memberid, int deviceid, int customertradeid) {
        this.customertradePK = new CustomertradePK(memberid, deviceid, customertradeid);
    }

    public CustomertradePK getCustomertradePK() {
        return customertradePK;
    }

    public void setCustomertradePK(CustomertradePK customertradePK) {
        this.customertradePK = customertradePK;
    }

    public String getStartsalesdate() {
        return startsalesdate;
    }

    public void setStartsalesdate(String startsalesdate) {
        this.startsalesdate = startsalesdate;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getTradeid() {
        return tradeid;
    }

    public void setTradeid(int tradeid) {
        this.tradeid = tradeid;
    }

    public int getDeliverymasterid() {
        return deliverymasterid;
    }

    public void setDeliverymasterid(int deliverymasterid) {
        this.deliverymasterid = deliverymasterid;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getTotaldeposit() {
        return totaldeposit;
    }

    public void setTotaldeposit(int totaldeposit) {
        this.totaldeposit = totaldeposit;
    }

    public int getTotalcredit() {
        return totalcredit;
    }

    public void setTotalcredit(int totalcredit) {
        this.totalcredit = totalcredit;
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
        hash += (customertradePK != null ? customertradePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomertradeVO)) {
            return false;
        }
        CustomertradeVO other = (CustomertradeVO) object;
        if ((this.customertradePK == null && other.customertradePK != null) || (this.customertradePK != null && !this.customertradePK.equals(other.customertradePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Customertrade[ customertradePK=" + customertradePK + " ]";
    }
    
}
