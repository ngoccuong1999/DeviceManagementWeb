/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.dbs;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ngoc Cuong
 */
@Entity
@Table(name = "device", catalog = "DeviceManagement", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d")
    , @NamedQuery(name = "Device.findById", query = "SELECT d FROM Device d WHERE d.id = :id")
    , @NamedQuery(name = "Device.findByDeviceName", query = "SELECT d FROM Device d WHERE d.deviceName = :deviceName")
    , @NamedQuery(name = "Device.findByDeviceDescription", query = "SELECT d FROM Device d WHERE d.deviceDescription = :deviceDescription")
    , @NamedQuery(name = "Device.findByDeviceType", query = "SELECT d FROM Device d WHERE d.deviceType = :deviceType")
    , @NamedQuery(name = "Device.findByTimeBuy", query = "SELECT d FROM Device d WHERE d.timeBuy = :timeBuy")
    , @NamedQuery(name = "Device.findByWarrantyPeriod", query = "SELECT d FROM Device d WHERE d.warrantyPeriod = :warrantyPeriod")
    , @NamedQuery(name = "Device.findByStatus", query = "SELECT d FROM Device d WHERE d.status = :status")})
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "device_name", nullable = false, length = 50)
    private String deviceName;
    @Column(name = "device_description", length = 50)
    private String deviceDescription;
    @Column(name = "device_type", length = 50)
    private String deviceType;
    @Basic(optional = false)
    @Column(name = "time_buy", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeBuy;
    @Basic(optional = false)
    @Column(name = "warranty_period", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date warrantyPeriod;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceId")
    private Collection<DeviceFix> deviceFixCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceId")
    private Collection<DevicePosition> devicePositionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceId")
    private Collection<DeviceImage> deviceImageCollection;
    @JoinColumn(name = "device_room_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private DeviceRoom deviceRoomId;

    public Device() {
    }

    public Device(Integer id) {
        this.id = id;
    }

    public Device(Integer id, String deviceName, Date timeBuy, Date warrantyPeriod, int status) {
        this.id = id;
        this.deviceName = deviceName;
        this.timeBuy = timeBuy;
        this.warrantyPeriod = warrantyPeriod;
        this.status = status;
    }

    public Device(Integer id, String deviceName, String deviceDescription, String deviceType, Date timeBuy, Date warrantyPeriod, int status, DeviceRoom deviceRoomId) {
        this.id = id;
        this.deviceName = deviceName;
        this.deviceDescription = deviceDescription;
        this.deviceType = deviceType;
        this.timeBuy = timeBuy;
        this.warrantyPeriod = warrantyPeriod;
        this.status = status;
        this.deviceRoomId = deviceRoomId;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Date getTimeBuy() {
        return timeBuy;
    }

    public void setTimeBuy(Date timeBuy) {
        this.timeBuy = timeBuy;
    }

    public Date getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(Date warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<DeviceFix> getDeviceFixCollection() {
        return deviceFixCollection;
    }

    public void setDeviceFixCollection(Collection<DeviceFix> deviceFixCollection) {
        this.deviceFixCollection = deviceFixCollection;
    }

    @XmlTransient
    public Collection<DevicePosition> getDevicePositionCollection() {
        return devicePositionCollection;
    }

    public void setDevicePositionCollection(Collection<DevicePosition> devicePositionCollection) {
        this.devicePositionCollection = devicePositionCollection;
    }

    @XmlTransient
    public Collection<DeviceImage> getDeviceImageCollection() {
        return deviceImageCollection;
    }

    public void setDeviceImageCollection(Collection<DeviceImage> deviceImageCollection) {
        this.deviceImageCollection = deviceImageCollection;
    }

    public DeviceRoom getDeviceRoomId() {
        return deviceRoomId;
    }

    public void setDeviceRoomId(DeviceRoom deviceRoomId) {
        this.deviceRoomId = deviceRoomId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cuongdn.dbs.Device[ id=" + id + " ]";
    }
    
}
