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
@Table(name = "POSSALESMONTH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Possalesmonth.findAll", query = "SELECT p FROM Possalesmonth p")})
public class PossalesmonthVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossalesmonthPK possalesmonthPK;
    @Size(max = 18)
    @Column(name = "SALES")
    private String sales;
    @Size(max = 18)
    @Column(name = "CARDSALES")
    private String cardsales;
    @Size(max = 18)
    @Column(name = "CASHTAXSALES")
    private String cashtaxsales;
    @Size(max = 18)
    @Column(name = "CASHONLYSALES")
    private String cashonlysales;
    @Size(max = 18)
    @Column(name = "CREDITSALES")
    private String creditsales;
    @Size(max = 18)
    @Column(name = "MODIFICATIONDATE")
    private String modificationdate;
    @Size(max = 18)
    @Column(name = "CREATIONDATE")
    private String creationdate;

    public PossalesmonthVO() {
    }

    public PossalesmonthVO(PossalesmonthPK possalesmonthPK) {
        this.possalesmonthPK = possalesmonthPK;
    }

    public PossalesmonthVO(int memberid, int deviceid, String yearmonth) {
        this.possalesmonthPK = new PossalesmonthPK(memberid, deviceid, yearmonth);
    }

    public PossalesmonthPK getPossalesmonthPK() {
        return possalesmonthPK;
    }

    public void setPossalesmonthPK(PossalesmonthPK possalesmonthPK) {
        this.possalesmonthPK = possalesmonthPK;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getCardsales() {
        return cardsales;
    }

    public void setCardsales(String cardsales) {
        this.cardsales = cardsales;
    }

    public String getCashtaxsales() {
        return cashtaxsales;
    }

    public void setCashtaxsales(String cashtaxsales) {
        this.cashtaxsales = cashtaxsales;
    }

    public String getCashonlysales() {
        return cashonlysales;
    }

    public void setCashonlysales(String cashonlysales) {
        this.cashonlysales = cashonlysales;
    }

    public String getCreditsales() {
        return creditsales;
    }

    public void setCreditsales(String creditsales) {
        this.creditsales = creditsales;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (possalesmonthPK != null ? possalesmonthPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossalesmonthVO)) {
            return false;
        }
        PossalesmonthVO other = (PossalesmonthVO) object;
        if ((this.possalesmonthPK == null && other.possalesmonthPK != null) || (this.possalesmonthPK != null && !this.possalesmonthPK.equals(other.possalesmonthPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Possalesmonth[ possalesmonthPK=" + possalesmonthPK + " ]";
    }
    
}
