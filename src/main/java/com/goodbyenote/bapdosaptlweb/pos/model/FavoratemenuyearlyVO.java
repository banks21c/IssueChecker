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
@Table(name = "FAVORATEMENUYEARLY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favoratemenuyearly.findAll", query = "SELECT f FROM Favoratemenuyearly f")})
public class FavoratemenuyearlyVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FavoratemenuyearlyPK favoratemenuyearlyPK;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "AMOUNT")
    private int amount;
    @Size(max = 18)
    @Column(name = "CREATIONDATE")
    private String creationdate;
    @Size(max = 18)
    @Column(name = "MODIFICATIONDATE")
    private String modificationdate;

    public FavoratemenuyearlyVO() {
    }

    public FavoratemenuyearlyVO(FavoratemenuyearlyPK favoratemenuyearlyPK) {
        this.favoratemenuyearlyPK = favoratemenuyearlyPK;
    }

    public FavoratemenuyearlyVO(int memberid, int deviceid, int memuid, String year) {
        this.favoratemenuyearlyPK = new FavoratemenuyearlyPK(memberid, deviceid, memuid, year);
    }

    public FavoratemenuyearlyPK getFavoratemenuyearlyPK() {
        return favoratemenuyearlyPK;
    }

    public void setFavoratemenuyearlyPK(FavoratemenuyearlyPK favoratemenuyearlyPK) {
        this.favoratemenuyearlyPK = favoratemenuyearlyPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
        hash += (favoratemenuyearlyPK != null ? favoratemenuyearlyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoratemenuyearlyVO)) {
            return false;
        }
        FavoratemenuyearlyVO other = (FavoratemenuyearlyVO) object;
        if ((this.favoratemenuyearlyPK == null && other.favoratemenuyearlyPK != null) || (this.favoratemenuyearlyPK != null && !this.favoratemenuyearlyPK.equals(other.favoratemenuyearlyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Favoratemenuyearly[ favoratemenuyearlyPK=" + favoratemenuyearlyPK + " ]";
    }
    
}
