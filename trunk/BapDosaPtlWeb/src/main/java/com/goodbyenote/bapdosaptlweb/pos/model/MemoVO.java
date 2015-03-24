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
@Table(name = "MEMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memo.findAll", query = "SELECT m FROM Memo m")})
public class MemoVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MemoPK memoPK;
    @Column(name = "DELIVERYMASTERID")
    private int deliverymasterid;
    @Column(name = "ORDERID")
    private int orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTSALESDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startsalesdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMOTYPE")
    private int memotype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESERVID")
    private int reservid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQUESTID")
    private int requestid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRADEID")
    private int tradeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "CONTENTS")
    private String contents;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISIMPORTANT")
    private Character isimportant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISCHECKED")
    private Character ischecked;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISDELETED")
    private Character isdeleted;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public MemoVO() {
    }

    public MemoVO(MemoPK memoPK) {
        this.memoPK = memoPK;
    }

    public MemoVO(MemoPK memoPK, Date startsalesdate, int memotype, int reservid, int requestid, int tradeid, String contents, Character isimportant, Character ischecked, Character isdeleted) {
        this.memoPK = memoPK;
        this.startsalesdate = startsalesdate;
        this.memotype = memotype;
        this.reservid = reservid;
        this.requestid = requestid;
        this.tradeid = tradeid;
        this.contents = contents;
        this.isimportant = isimportant;
        this.ischecked = ischecked;
        this.isdeleted = isdeleted;
    }

    public MemoVO(int memberid, int deviceid, int memoid) {
        this.memoPK = new MemoPK(memberid, deviceid, memoid);
    }

    public MemoPK getMemoPK() {
        return memoPK;
    }

    public void setMemoPK(MemoPK memoPK) {
        this.memoPK = memoPK;
    }

    public int getDeliverymasterid() {
        return deliverymasterid;
    }

    public void setDeliverymasterid(int deliverymasterid) {
        this.deliverymasterid = deliverymasterid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Date getStartsalesdate() {
        return startsalesdate;
    }

    public void setStartsalesdate(Date startsalesdate) {
        this.startsalesdate = startsalesdate;
    }

    public int getMemotype() {
        return memotype;
    }

    public void setMemotype(int memotype) {
        this.memotype = memotype;
    }

    public int getReservid() {
        return reservid;
    }

    public void setReservid(int reservid) {
        this.reservid = reservid;
    }

    public int getRequestid() {
        return requestid;
    }

    public void setRequestid(int requestid) {
        this.requestid = requestid;
    }

    public int getTradeid() {
        return tradeid;
    }

    public void setTradeid(int tradeid) {
        this.tradeid = tradeid;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Character getIsimportant() {
        return isimportant;
    }

    public void setIsimportant(Character isimportant) {
        this.isimportant = isimportant;
    }

    public Character getIschecked() {
        return ischecked;
    }

    public void setIschecked(Character ischecked) {
        this.ischecked = ischecked;
    }

    public Character getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Character isdeleted) {
        this.isdeleted = isdeleted;
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
        hash += (memoPK != null ? memoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemoVO)) {
            return false;
        }
        MemoVO other = (MemoVO) object;
        if ((this.memoPK == null && other.memoPK != null) || (this.memoPK != null && !this.memoPK.equals(other.memoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Memo[ memoPK=" + memoPK + " ]";
    }
    
}
