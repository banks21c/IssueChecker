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
@Table(name = "POSSALESDAY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Possalesday.findAll", query = "SELECT p FROM Possalesday p")})
public class PossalesdayVO extends PosCommonVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "STARTMONEY")
    private int startmoney;
    @Column(name = "CASHRECEIPT")
    private int cashreceipt;
    @Column(name = "CREDITRECEIPT")
    private int creditreceipt;
    @Column(name = "LASTMONEY")
    private int lastmoney;
    @Column(name = "CARDPAYMENT")
    private int cardpayment;
    @Column(name = "CASHTAXSALES")
    private int cashtaxsales;
    @Column(name = "CASHONLYSALES")
    private int cashonlysales;
    @Size(max = 18)
    @Column(name = "MODIFICATIONDATE")
    private String modificationdate;
    @Size(max = 18)
    @Column(name = "CREATIONDATE")
    private String creationdate;

    public PossalesdayVO() {
    }

    public int getStartmoney() {
        return startmoney;
    }

    public void setStartmoney(int startmoney) {
        this.startmoney = startmoney;
    }

    public int getCashreceipt() {
        return cashreceipt;
    }

    public void setCashreceipt(int cashreceipt) {
        this.cashreceipt = cashreceipt;
    }

    public int getCreditreceipt() {
        return creditreceipt;
    }

    public void setCreditreceipt(int creditreceipt) {
        this.creditreceipt = creditreceipt;
    }

    public int getLastmoney() {
        return lastmoney;
    }

    public void setLastmoney(int lastmoney) {
        this.lastmoney = lastmoney;
    }

    public int getCardpayment() {
        return cardpayment;
    }

    public void setCardpayment(int cardpayment) {
        this.cardpayment = cardpayment;
    }

    public int getCashtaxsales() {
        return cashtaxsales;
    }

    public void setCashtaxsales(int cashtaxsales) {
        this.cashtaxsales = cashtaxsales;
    }

    public int getCashonlysales() {
        return cashonlysales;
    }

    public void setCashonlysales(int cashonlysales) {
        this.cashonlysales = cashonlysales;
    }

    public String getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(String modificationdate) {
        this.modificationdate = modificationdate;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }
    
}
