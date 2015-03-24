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
@Table(name = "BUILDING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Building.findAll", query = "SELECT b FROM Building b")})
public class BuildingVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BuildingPK buildingPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISAPT")
    private Character isapt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUILDINGTYPE")
    private int buildingtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "NAME")
    private String name;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public BuildingVO() {
    }

    public BuildingVO(BuildingPK buildingPK) {
        this.buildingPK = buildingPK;
    }

    public BuildingVO(BuildingPK buildingPK, Character isapt, int buildingtype, String name) {
        this.buildingPK = buildingPK;
        this.isapt = isapt;
        this.buildingtype = buildingtype;
        this.name = name;
    }

    public BuildingVO(int memberid, int deviceid, int buildingid) {
        this.buildingPK = new BuildingPK(memberid, deviceid, buildingid);
    }

    public BuildingPK getBuildingPK() {
        return buildingPK;
    }

    public void setBuildingPK(BuildingPK buildingPK) {
        this.buildingPK = buildingPK;
    }

    public Character getIsapt() {
        return isapt;
    }

    public void setIsapt(Character isapt) {
        this.isapt = isapt;
    }

    public int getBuildingtype() {
        return buildingtype;
    }

    public void setBuildingtype(int buildingtype) {
        this.buildingtype = buildingtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (buildingPK != null ? buildingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuildingVO)) {
            return false;
        }
        BuildingVO other = (BuildingVO) object;
        if ((this.buildingPK == null && other.buildingPK != null) || (this.buildingPK != null && !this.buildingPK.equals(other.buildingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Building[ buildingPK=" + buildingPK + " ]";
    }
    
}
