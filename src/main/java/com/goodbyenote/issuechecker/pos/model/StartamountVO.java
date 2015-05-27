/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodbyenote.issuechecker.pos.model;

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
@Table(name = "STARTAMOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Startamount.findAll", query = "SELECT s FROM Startamount s")})
public class StartamountVO extends PosCommonVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 18)
    @Column(name = "STARTAMOUNT")
    private String startamount;
    @Size(max = 18)
    @Column(name = "REMAINS")
    private String remains;
    @Column(name = "RETURNS")
    private int returns;
    @Size(max = 18)
    @Column(name = "CREATIONDATE")
    private String creationdate;
    @Size(max = 18)
    @Column(name = "MODIFICATIONDATE")
    private String modificationdate;

    public StartamountVO() {
    }

    public String getStartamount() {
        return startamount;
    }

    public void setStartamount(String startamount) {
        this.startamount = startamount;
    }

    public String getRemains() {
        return remains;
    }

    public void setRemains(String remains) {
        this.remains = remains;
    }

    public int getReturns() {
        return returns;
    }

    public void setReturns(int returns) {
        this.returns = returns;
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
}
