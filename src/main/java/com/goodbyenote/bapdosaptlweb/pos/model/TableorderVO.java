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
@Table(name = "TABLEORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tableorder.findAll", query = "SELECT t FROM Tableorder t")})
public class TableorderVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TableorderPK tableorderPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TABLEID")
    private int tableid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTSALESDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startsalesdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
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
    @Column(name = "INTOLOSS")
    private int intoloss;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTODEPOSIT")
    private int intodeposit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USEDTICKET")
    private int usedticket;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SAVEDPOINT")
    private int savedpoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USEDDEPOSIT")
    private int useddeposit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USEDPOINT")
    private int usedpoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISCHANGEAFTERMERGE")
    private Character ischangeaftermerge;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public TableorderVO() {
    }

    public TableorderVO(TableorderPK tableorderPK) {
        this.tableorderPK = tableorderPK;
    }

    public TableorderVO(TableorderPK tableorderPK, int tableid, Date startsalesdate, int customerid, int price, int givebackcredit, int loss, int discount, int billmoney, int cashpayment, int cardpayment, int intocredit, int intoloss, int intodeposit, int usedticket, int savedpoint, int useddeposit, int usedpoint, Character ischangeaftermerge) {
        this.tableorderPK = tableorderPK;
        this.tableid = tableid;
        this.startsalesdate = startsalesdate;
        this.customerid = customerid;
        this.price = price;
        this.givebackcredit = givebackcredit;
        this.loss = loss;
        this.discount = discount;
        this.billmoney = billmoney;
        this.cashpayment = cashpayment;
        this.cardpayment = cardpayment;
        this.intocredit = intocredit;
        this.intoloss = intoloss;
        this.intodeposit = intodeposit;
        this.usedticket = usedticket;
        this.savedpoint = savedpoint;
        this.useddeposit = useddeposit;
        this.usedpoint = usedpoint;
        this.ischangeaftermerge = ischangeaftermerge;
    }

    public TableorderVO(int memberid, int deviceid, int orderid) {
        this.tableorderPK = new TableorderPK(memberid, deviceid, orderid);
    }

    public TableorderPK getTableorderPK() {
        return tableorderPK;
    }

    public void setTableorderPK(TableorderPK tableorderPK) {
        this.tableorderPK = tableorderPK;
    }

    public int getTableid() {
        return tableid;
    }

    public void setTableid(int tableid) {
        this.tableid = tableid;
    }

    public Date getStartsalesdate() {
        return startsalesdate;
    }

    public void setStartsalesdate(Date startsalesdate) {
        this.startsalesdate = startsalesdate;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getIntoloss() {
        return intoloss;
    }

    public void setIntoloss(int intoloss) {
        this.intoloss = intoloss;
    }

    public int getIntodeposit() {
        return intodeposit;
    }

    public void setIntodeposit(int intodeposit) {
        this.intodeposit = intodeposit;
    }

    public int getUsedticket() {
        return usedticket;
    }

    public void setUsedticket(int usedticket) {
        this.usedticket = usedticket;
    }

    public int getSavedpoint() {
        return savedpoint;
    }

    public void setSavedpoint(int savedpoint) {
        this.savedpoint = savedpoint;
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

    public Character getIschangeaftermerge() {
        return ischangeaftermerge;
    }

    public void setIschangeaftermerge(Character ischangeaftermerge) {
        this.ischangeaftermerge = ischangeaftermerge;
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
        hash += (tableorderPK != null ? tableorderPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableorderVO)) {
            return false;
        }
        TableorderVO other = (TableorderVO) object;
        if ((this.tableorderPK == null && other.tableorderPK != null) || (this.tableorderPK != null && !this.tableorderPK.equals(other.tableorderPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Tableorder[ tableorderPK=" + tableorderPK + " ]";
    }
    
}
