package com.goodbyenote.issuechecker.pos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MainVO extends PosCommonVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMOID")
    private int memoid;
    @Column(name = "DELIVERYMASTERID")
    private int deliverymasterid;
    @Column(name = "ORDERID")
    private int orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMOTYPE")
    private char memotype;
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

    public MainVO() {
    }

    public int getMemoid() {
        return memoid;
    }

    public void setMemoid(int memoid) {
        this.memoid = memoid;
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

    public char getMemotype() {
        return memotype;
    }

    public void setMemotype(char memotype) {
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

}
