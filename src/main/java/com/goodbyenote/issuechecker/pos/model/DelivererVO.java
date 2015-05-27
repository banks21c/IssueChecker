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
@Table(name = "DELIVERER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliverer.findAll", query = "SELECT d FROM Deliverer d")})
public class DelivererVO extends PosCommonVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 18)
    @Column(name = "DELIVERERNAME")
    private String deliverername;
    @Size(max = 18)
    @Column(name = "DELIVERERPHONENUMBER")
    private String delivererphonenumber;
    @Size(max = 18)
    @Column(name = "CREATIONDATE")
    private String creationdate;
    @Size(max = 18)
    @Column(name = "MODIFICATIONDATE")
    private String modificationdate;

    public DelivererVO() {
    }

    public String getDeliverername() {
        return deliverername;
    }

    public void setDeliverername(String deliverername) {
        this.deliverername = deliverername;
    }

    public String getDelivererphonenumber() {
        return delivererphonenumber;
    }

    public void setDelivererphonenumber(String delivererphonenumber) {
        this.delivererphonenumber = delivererphonenumber;
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
