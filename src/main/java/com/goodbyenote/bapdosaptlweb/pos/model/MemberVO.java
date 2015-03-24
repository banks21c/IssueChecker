/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodbyenote.bapdosaptlweb.pos.model;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "MEMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Member.findAll", query = "SELECT m FROM Member m")})
public class MemberVO implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBERID")
    private BigDecimal memberid;
    @Column(name = "STARTBUSINESSDESIREYN")
    private Character startbusinessdesireyn;
    @Column(name = "FRANCHISEJOINYN")
    private Character franchisejoinyn;
    @Size(max = 18)
    @Column(name = "ITEM")
    private String item;
    @Size(max = 18)
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @Size(max = 18)
    @Column(name = "PHONENUMBER2")
    private String phonenumber2;
    @Size(max = 30)
    @Column(name = "ADDRESS1")
    private String address1;
    @Size(max = 30)
    @Column(name = "ADDRESS2")
    private String address2;
    @Size(max = 8)
    @Column(name = "BIRTHDAY")
    private String birthday;
    @Column(name = "APPENGAGEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appengagedate;
    @Column(name = "ESEROEXTRACT")
    private Character eseroextract;
    @Column(name = "BEFORESALES")
    private int beforesales;
    @Column(name = "LASTCONSULTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastconsultdate;
    @Column(name = "AVAILABLEMONEY")
    private int availablemoney;
    @Size(max = 18)
    @Column(name = "BUSINESSTYPE")
    private String businesstype;
    @Size(max = 20)
    @Column(name = "MEMBERNAME")
    private String membername;
    @Size(max = 10)
    @Column(name = "BUSINESSNUMBER")
    private String businessnumber;
    @Column(name = "GENDER")
    private Character gender;
    @Size(max = 18)
    @Column(name = "MEMBERTYPE")
    private String membertype;
    @Column(name = "ESEROJOINYN")
    private Character eserojoinyn;
    @Column(name = "TAXACCOUNTACCEPTYN")
    private Character taxaccountacceptyn;
    @Column(name = "OPENDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opendate;
    @Size(max = 18)
    @Column(name = "CREATIONDATE")
    private String creationdate;
    @Size(max = 18)
    @Column(name = "MODIFICATIONDATE")
    private String modificationdate;

    public MemberVO() {
    }

    public MemberVO(BigDecimal memberid) {
        this.memberid = memberid;
    }

    public BigDecimal getMemberid() {
        return memberid;
    }

    public void setMemberid(BigDecimal memberid) {
        this.memberid = memberid;
    }

    public Character getStartbusinessdesireyn() {
        return startbusinessdesireyn;
    }

    public void setStartbusinessdesireyn(Character startbusinessdesireyn) {
        this.startbusinessdesireyn = startbusinessdesireyn;
    }

    public Character getFranchisejoinyn() {
        return franchisejoinyn;
    }

    public void setFranchisejoinyn(Character franchisejoinyn) {
        this.franchisejoinyn = franchisejoinyn;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber2() {
        return phonenumber2;
    }

    public void setPhonenumber2(String phonenumber2) {
        this.phonenumber2 = phonenumber2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Date getAppengagedate() {
        return appengagedate;
    }

    public void setAppengagedate(Date appengagedate) {
        this.appengagedate = appengagedate;
    }

    public Character getEseroextract() {
        return eseroextract;
    }

    public void setEseroextract(Character eseroextract) {
        this.eseroextract = eseroextract;
    }

    public int getBeforesales() {
        return beforesales;
    }

    public void setBeforesales(int beforesales) {
        this.beforesales = beforesales;
    }

    public Date getLastconsultdate() {
        return lastconsultdate;
    }

    public void setLastconsultdate(Date lastconsultdate) {
        this.lastconsultdate = lastconsultdate;
    }

    public int getAvailablemoney() {
        return availablemoney;
    }

    public void setAvailablemoney(int availablemoney) {
        this.availablemoney = availablemoney;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getBusinessnumber() {
        return businessnumber;
    }

    public void setBusinessnumber(String businessnumber) {
        this.businessnumber = businessnumber;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    public Character getEserojoinyn() {
        return eserojoinyn;
    }

    public void setEserojoinyn(Character eserojoinyn) {
        this.eserojoinyn = eserojoinyn;
    }

    public Character getTaxaccountacceptyn() {
        return taxaccountacceptyn;
    }

    public void setTaxaccountacceptyn(Character taxaccountacceptyn) {
        this.taxaccountacceptyn = taxaccountacceptyn;
    }

    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
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
        hash += (memberid != null ? memberid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberVO)) {
            return false;
        }
        MemberVO other = (MemberVO) object;
        if ((this.memberid == null && other.memberid != null) || (this.memberid != null && !this.memberid.equals(other.memberid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Member[ memberid=" + memberid + " ]";
    }
    
}
