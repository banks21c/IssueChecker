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
@Table(name = "FAVORATEMENUHOURLY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favoratemenuhourly.findAll", query = "SELECT f FROM Favoratemenuhourly f")})
public class FavoratemenuhourlyVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FavoratemenuhourlyPK favoratemenuhourlyPK;
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

    public FavoratemenuhourlyVO() {
    }

    public FavoratemenuhourlyVO(FavoratemenuhourlyPK favoratemenuhourlyPK) {
        this.favoratemenuhourlyPK = favoratemenuhourlyPK;
    }

    public FavoratemenuhourlyVO(int memberid, int deviceid, int memuid, String startsalesdate, String hour) {
        this.favoratemenuhourlyPK = new FavoratemenuhourlyPK(memberid, deviceid, memuid, startsalesdate, hour);
    }

    public FavoratemenuhourlyPK getFavoratemenuhourlyPK() {
        return favoratemenuhourlyPK;
    }

    public void setFavoratemenuhourlyPK(FavoratemenuhourlyPK favoratemenuhourlyPK) {
        this.favoratemenuhourlyPK = favoratemenuhourlyPK;
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
        hash += (favoratemenuhourlyPK != null ? favoratemenuhourlyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoratemenuhourlyVO)) {
            return false;
        }
        FavoratemenuhourlyVO other = (FavoratemenuhourlyVO) object;
        if ((this.favoratemenuhourlyPK == null && other.favoratemenuhourlyPK != null) || (this.favoratemenuhourlyPK != null && !this.favoratemenuhourlyPK.equals(other.favoratemenuhourlyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Favoratemenuhourly[ favoratemenuhourlyPK=" + favoratemenuhourlyPK + " ]";
    }
    
}
