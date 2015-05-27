/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodbyenote.issuechecker.pos.model;

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
@Table(name = "POINT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Point.findAll", query = "SELECT p FROM Point p")})
public class PointVO extends PosCommonVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POINTTYPE")
    private int pointtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALPOINT")
    private int totalpoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USEDPOINT")
    private int usedpoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REMAINPOINT")
    private int remainpoint;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public PointVO() {
    }

    public int getPointtype() {
        return pointtype;
    }

    public void setPointtype(int pointtype) {
        this.pointtype = pointtype;
    }

    public int getTotalpoint() {
        return totalpoint;
    }

    public void setTotalpoint(int totalpoint) {
        this.totalpoint = totalpoint;
    }

    public int getUsedpoint() {
        return usedpoint;
    }

    public void setUsedpoint(int usedpoint) {
        this.usedpoint = usedpoint;
    }

    public int getRemainpoint() {
        return remainpoint;
    }

    public void setRemainpoint(int remainpoint) {
        this.remainpoint = remainpoint;
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
}
