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
@Table(name = "RESERVATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")})
public class ReservationVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservationPK reservationPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTSALESDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startsalesdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TABLENO")
    private int tableno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "CUSTOMERNAME")
    private String customername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SMSSENDTIME")
    private int smssendtime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESERVTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservtime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMBEROFPEOPLE")
    private int numberofpeople;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "MEMO")
    private String memo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private int orderid;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public ReservationVO() {
    }

    public ReservationVO(ReservationPK reservationPK) {
        this.reservationPK = reservationPK;
    }

    public ReservationVO(ReservationPK reservationPK, Date startsalesdate, int tableno, int customerid, String customername, String phonenumber, int smssendtime, Date reservtime, int numberofpeople, String memo, int status, int orderid) {
        this.reservationPK = reservationPK;
        this.startsalesdate = startsalesdate;
        this.tableno = tableno;
        this.customerid = customerid;
        this.customername = customername;
        this.phonenumber = phonenumber;
        this.smssendtime = smssendtime;
        this.reservtime = reservtime;
        this.numberofpeople = numberofpeople;
        this.memo = memo;
        this.status = status;
        this.orderid = orderid;
    }

    public ReservationVO(int memberid, int deviceid, int reservid) {
        this.reservationPK = new ReservationPK(memberid, deviceid, reservid);
    }

    public ReservationPK getReservationPK() {
        return reservationPK;
    }

    public void setReservationPK(ReservationPK reservationPK) {
        this.reservationPK = reservationPK;
    }

    public Date getStartsalesdate() {
        return startsalesdate;
    }

    public void setStartsalesdate(Date startsalesdate) {
        this.startsalesdate = startsalesdate;
    }

    public int getTableno() {
        return tableno;
    }

    public void setTableno(int tableno) {
        this.tableno = tableno;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getSmssendtime() {
        return smssendtime;
    }

    public void setSmssendtime(int smssendtime) {
        this.smssendtime = smssendtime;
    }

    public Date getReservtime() {
        return reservtime;
    }

    public void setReservtime(Date reservtime) {
        this.reservtime = reservtime;
    }

    public int getNumberofpeople() {
        return numberofpeople;
    }

    public void setNumberofpeople(int numberofpeople) {
        this.numberofpeople = numberofpeople;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
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
        hash += (reservationPK != null ? reservationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationVO)) {
            return false;
        }
        ReservationVO other = (ReservationVO) object;
        if ((this.reservationPK == null && other.reservationPK != null) || (this.reservationPK != null && !this.reservationPK.equals(other.reservationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Reservation[ reservationPK=" + reservationPK + " ]";
    }
    
}
