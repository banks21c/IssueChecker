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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "COMPAREREGION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compareregion.findAll", query = "SELECT c FROM Compareregion c")})
public class CompareregionVO extends PosCommonVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "COMPAREREGIONID")
    private int compareregionid;

    public CompareregionVO() {
    }

    public int getCompareregionid() {
        return compareregionid;
    }

    public void setCompareregionid(int compareregionid) {
        this.compareregionid = compareregionid;
    }
}
