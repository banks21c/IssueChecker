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
@Table(name = "CLASSBYBUILDINGMONTHLY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classbybuildingmonthly.findAll", query = "SELECT c FROM Classbybuildingmonthly c")})
public class ClassbybuildingmonthlyVO extends PosCommonVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 18)
    @Column(name = "SALESAMOUNT")
    private String salesamount;
    @Size(max = 18)
    @Column(name = "CREATIONDATE")
    private String creationdate;
    @Size(max = 18)
    @Column(name = "MODIFICATIONDATE")
    private String modificationdate;

    public ClassbybuildingmonthlyVO() {
    }

    public String getSalesamount() {
        return salesamount;
    }

    public void setSalesamount(String salesamount) {
        this.salesamount = salesamount;
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
