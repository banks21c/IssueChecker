/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goodbyenote.bapdosaptlweb.pos.model;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "DEVICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d")})
public class DeviceVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DevicePK devicePK;
    @Size(max = 50)
    @Column(name = "IDENTIFYNO")
    private String identifyno;
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public DeviceVO() {
    }

    public DeviceVO(DevicePK devicePK) {
        this.devicePK = devicePK;
    }

    public DeviceVO(int memberid, int deviceid) {
        this.devicePK = new DevicePK(memberid, deviceid);
    }

    public DevicePK getDevicePK() {
        return devicePK;
    }

    public void setDevicePK(DevicePK devicePK) {
        this.devicePK = devicePK;
    }

    public String getIdentifyno() {
        return identifyno;
    }

    public void setIdentifyno(String identifyno) {
        this.identifyno = identifyno;
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
        hash += (devicePK != null ? devicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeviceVO)) {
            return false;
        }
        DeviceVO other = (DeviceVO) object;
        if ((this.devicePK == null && other.devicePK != null) || (this.devicePK != null && !this.devicePK.equals(other.devicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goodbyenote.bapdosaptlweb.pos.model.Device[ devicePK=" + devicePK + " ]";
    }
    
}
