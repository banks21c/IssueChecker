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
@Table(name = "POSSALESHOURLY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Possaleshourly.findAll", query = "SELECT p FROM Possaleshourly p")})
public class PossaleshourlyVO extends PosCommonVO implements Serializable {
    private static final long serialVersionUID = 1L;
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
    
}
