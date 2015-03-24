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
@Table(name = "POSSALESHOURLY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Possaleshourly.findAll", query = "SELECT p FROM Possaleshourly p")})
public class PossaleshourlyVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PossaleshourlyPK possaleshourlyPK;
    @Column(name = "SALESAMOUNT")
    private int salesamount;
    @Size(max = 18)
    @Column(name = "MODIFICATIONDATE")
    private String modificationdate;
    @Size(max = 18)
    @Column(name = "CREATIONDATE")
    private String creationdate;

    public PossaleshourlyVO() {
    }

    public PossaleshourlyVO(PossaleshourlyPK possaleshourlyPK) {
        this.possaleshourlyPK = possaleshourlyPK;
    }

    public PossaleshourlyVO(int memberid, int deviceid, String startsalesdate, String hour) {
        this.possaleshourlyPK = new PossaleshourlyPK(memberid, deviceid, startsalesdate, hour);
    }

    public PossaleshourlyPK getPossaleshourlyPK() {
        return possaleshourlyPK;
    }

    public void setPossaleshourlyPK(PossaleshourlyPK possaleshourlyPK) {
        this.possaleshourlyPK = possaleshourlyPK;
    }

    public int getSalesamount() {
        return salesamount;
    }

    public void setSalesamount(int salesamount) {
        this.salesamount = salesamount;
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
        hash += (possaleshourlyPK != null ? possaleshourlyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PossaleshourlyVO)) {
            return false;
        }
        PossaleshourlyVO other = (PossaleshourlyVO) object;
        if ((this.possaleshourlyPK == null && other.possaleshourlyPK != null) || (this.possaleshourlyPK != null && !this.possaleshourlyPK.equals(other.possaleshourlyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Possaleshourly[ possaleshourlyPK=" + possaleshourlyPK + " ]";
    }
    
}
