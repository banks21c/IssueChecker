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
@Table(name = "DELIVERYMASTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliverymaster.findAll", query = "SELECT d FROM Deliverymaster d")})
public class DeliverymasterVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeliverymasterPK deliverymasterPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTSALESDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startsalesdate;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CASHPAYMENT")
    private int cashpayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARDPAYMENT")
    private int cardpayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTOCREDIT")
    private int intocredit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GIVEBACKCREDIT")
    private int givebackcredit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOSS")
    private int loss;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISCOUNT")
    private int discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BILLMONEY")
    private int billmoney;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTODEPOSIT")
    private int intodeposit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISPICKUPDISH")
    private Character ispickupdish;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPLETEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISPICKUPMONEY")
    private Character ispickupmoney;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISCOMPLETED")
    private Character iscompleted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISHURRY")
    private Character ishurry;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTOLOSS")
    private int intoloss;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SAVEDPOINT")
    private int savedpoint;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "CUSTOMERNAME")
    private String customername;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LASTDELIVERID")
    private int lastdeliverid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "MEMO")
    private String memo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USEDTICKET")
    private int usedticket;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USEDDEPOSIT")
    private int useddeposit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USEDPOINT")
    private int usedpoint;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public DeliverymasterVO() {
    }

    public DeliverymasterVO(DeliverymasterPK deliverymasterPK) {
        this.deliverymasterPK = deliverymasterPK;
    }

    public DeliverymasterVO(DeliverymasterPK deliverymasterPK, Date startsalesdate, int status, int price, int cashpayment, int cardpayment, int intocredit, int givebackcredit, int loss, int discount, int billmoney, int intodeposit, Character ispickupdish, Date completedate, int customerid, Character ispickupmoney, Character iscompleted, Character ishurry, int intoloss, int savedpoint, String address, String phonenumber, String customername, int lastdeliverid, String memo, int usedticket, int useddeposit, int usedpoint) {
        this.deliverymasterPK = deliverymasterPK;
        this.startsalesdate = startsalesdate;
        this.status = status;
        this.price = price;
        this.cashpayment = cashpayment;
        this.cardpayment = cardpayment;
        this.intocredit = intocredit;
        this.givebackcredit = givebackcredit;
        this.loss = loss;
        this.discount = discount;
        this.billmoney = billmoney;
        this.intodeposit = intodeposit;
        this.ispickupdish = ispickupdish;
        this.completedate = completedate;
        this.customerid = customerid;
        this.ispickupmoney = ispickupmoney;
        this.iscompleted = iscompleted;
        this.ishurry = ishurry;
        this.intoloss = intoloss;
        this.savedpoint = savedpoint;
        this.address = address;
        this.phonenumber = phonenumber;
        this.customername = customername;
        this.lastdeliverid = lastdeliverid;
        this.memo = memo;
        this.usedticket = usedticket;
        this.useddeposit = useddeposit;
        this.usedpoint = usedpoint;
    }

    public DeliverymasterVO(int memberid, int deviceid, int deliverymasterid) {
        this.deliverymasterPK = new DeliverymasterPK(memberid, deviceid, deliverymasterid);
    }

    public DeliverymasterPK getDeliverymasterPK() {
        return deliverymasterPK;
    }

    public void setDeliverymasterPK(DeliverymasterPK deliverymasterPK) {
        this.deliverymasterPK = deliverymasterPK;
    }

    public Date getStartsalesdate() {
        return startsalesdate;
    }

    public void setStartsalesdate(Date startsalesdate) {
        this.startsalesdate = startsalesdate;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCashpayment() {
        return cashpayment;
    }

    public void setCashpayment(int cashpayment) {
        this.cashpayment = cashpayment;
    }

    public int getCardpayment() {
        return cardpayment;
    }

    public void setCardpayment(int cardpayment) {
        this.cardpayment = cardpayment;
    }

    public int getIntocredit() {
        return intocredit;
    }

    public void setIntocredit(int intocredit) {
        this.intocredit = intocredit;
    }

    public int getGivebackcredit() {
        return givebackcredit;
    }

    public void setGivebackcredit(int givebackcredit) {
        this.givebackcredit = givebackcredit;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getBillmoney() {
        return billmoney;
    }

    public void setBillmoney(int billmoney) {
        this.billmoney = billmoney;
    }

    public int getIntodeposit() {
        return intodeposit;
    }

    public void setIntodeposit(int intodeposit) {
        this.intodeposit = intodeposit;
    }

    public Character getIspickupdish() {
        return ispickupdish;
    }

    public void setIspickupdish(Character ispickupdish) {
        this.ispickupdish = ispickupdish;
    }

    public Date getCompletedate() {
        return completedate;
    }

    public void setCompletedate(Date completedate) {
        this.completedate = completedate;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public Character getIspickupmoney() {
        return ispickupmoney;
    }

    public void setIspickupmoney(Character ispickupmoney) {
        this.ispickupmoney = ispickupmoney;
    }

    public Character getIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(Character iscompleted) {
        this.iscompleted = iscompleted;
    }

    public Character getIshurry() {
        return ishurry;
    }

    public void setIshurry(Character ishurry) {
        this.ishurry = ishurry;
    }

    public int getIntoloss() {
        return intoloss;
    }

    public void setIntoloss(int intoloss) {
        this.intoloss = intoloss;
    }

    public int getSavedpoint() {
        return savedpoint;
    }

    public void setSavedpoint(int savedpoint) {
        this.savedpoint = savedpoint;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public int getLastdeliverid() {
        return lastdeliverid;
    }

    public void setLastdeliverid(int lastdeliverid) {
        this.lastdeliverid = lastdeliverid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getUsedticket() {
        return usedticket;
    }

    public void setUsedticket(int usedticket) {
        this.usedticket = usedticket;
    }

    public int getUseddeposit() {
        return useddeposit;
    }

    public void setUseddeposit(int useddeposit) {
        this.useddeposit = useddeposit;
    }

    public int getUsedpoint() {
        return usedpoint;
    }

    public void setUsedpoint(int usedpoint) {
        this.usedpoint = usedpoint;
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
        hash += (deliverymasterPK != null ? deliverymasterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliverymasterVO)) {
            return false;
        }
        DeliverymasterVO other = (DeliverymasterVO) object;
        if ((this.deliverymasterPK == null && other.deliverymasterPK != null) || (this.deliverymasterPK != null && !this.deliverymasterPK.equals(other.deliverymasterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Deliverymaster[ deliverymasterPK=" + deliverymasterPK + " ]";
    }
    
}
