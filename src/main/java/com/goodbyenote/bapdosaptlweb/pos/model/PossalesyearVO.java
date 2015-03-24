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
@Table(name = "POSSALESYEAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Possalesyear.findAll", query = "SELECT p FROM Possalesyear p")})
public class PossalesyearVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossalesyearPK possalesyearPK;
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

    public PossalesyearVO() {
    }

    public PossalesyearVO(PossalesyearPK possalesyearPK) {
        this.possalesyearPK = possalesyearPK;
    }

    public PossalesyearVO(int memberid, int deviceid, String year) {
        this.possalesyearPK = new PossalesyearPK(memberid, deviceid, year);
    }

    public PossalesyearPK getPossalesyearPK() {
        return possalesyearPK;
    }

    public void setPossalesyearPK(PossalesyearPK possalesyearPK) {
        this.possalesyearPK = possalesyearPK;
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
        hash += (possalesyearPK != null ? possalesyearPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossalesyearVO)) {
            return false;
        }
        PossalesyearVO other = (PossalesyearVO) object;
        if ((this.possalesyearPK == null && other.possalesyearPK != null) || (this.possalesyearPK != null && !this.possalesyearPK.equals(other.possalesyearPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Possalesyear[ possalesyearPK=" + possalesyearPK + " ]";
    }
    
}
