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
@Table(name = "FAVORATEMENUMONTHLY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favoratemenumonthly.findAll", query = "SELECT f FROM Favoratemenumonthly f")})
public class FavoratemenumonthlyVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FavoratemenumonthlyPK favoratemenumonthlyPK;
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

    public FavoratemenumonthlyVO() {
    }

    public FavoratemenumonthlyVO(FavoratemenumonthlyPK favoratemenumonthlyPK) {
        this.favoratemenumonthlyPK = favoratemenumonthlyPK;
    }

    public FavoratemenumonthlyVO(int memberid, int deviceid, int memuid, String yearmonth) {
        this.favoratemenumonthlyPK = new FavoratemenumonthlyPK(memberid, deviceid, memuid, yearmonth);
    }

    public FavoratemenumonthlyPK getFavoratemenumonthlyPK() {
        return favoratemenumonthlyPK;
    }

    public void setFavoratemenumonthlyPK(FavoratemenumonthlyPK favoratemenumonthlyPK) {
        this.favoratemenumonthlyPK = favoratemenumonthlyPK;
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
        hash += (favoratemenumonthlyPK != null ? favoratemenumonthlyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoratemenumonthlyVO)) {
            return false;
        }
        FavoratemenumonthlyVO other = (FavoratemenumonthlyVO) object;
        if ((this.favoratemenumonthlyPK == null && other.favoratemenumonthlyPK != null) || (this.favoratemenumonthlyPK != null && !this.favoratemenumonthlyPK.equals(other.favoratemenumonthlyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Favoratemenumonthly[ favoratemenumonthlyPK=" + favoratemenumonthlyPK + " ]";
    }
    
}
