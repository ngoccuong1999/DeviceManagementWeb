/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.dbs;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ngoc Cuong
 */
@Entity
@Table(name = "device_room", catalog = "DeviceManagement", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceRoom.findAll", query = "SELECT d FROM DeviceRoom d")
    , @NamedQuery(name = "DeviceRoom.findById", query = "SELECT d FROM DeviceRoom d WHERE d.id = :id")
    , @NamedQuery(name = "DeviceRoom.findByName", query = "SELECT d FROM DeviceRoom d WHERE d.name = :name")})
public class DeviceRoom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @OneToMany(mappedBy = "deviceRoomId")
    private Collection<UserInfo> userInfoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceRoomId")
    private Collection<DevicePosition> devicePositionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceRoomId")
    private Collection<Device> deviceCollection;

    public DeviceRoom() {
    }

    public DeviceRoom(Integer id) {
        this.id = id;
    }

    public DeviceRoom(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<UserInfo> getUserInfoCollection() {
        return userInfoCollection;
    }

    public void setUserInfoCollection(Collection<UserInfo> userInfoCollection) {
        this.userInfoCollection = userInfoCollection;
    }

    @XmlTransient
    public Collection<DevicePosition> getDevicePositionCollection() {
        return devicePositionCollection;
    }

    public void setDevicePositionCollection(Collection<DevicePosition> devicePositionCollection) {
        this.devicePositionCollection = devicePositionCollection;
    }

    @XmlTransient
    public Collection<Device> getDeviceCollection() {
        return deviceCollection;
    }

    public void setDeviceCollection(Collection<Device> deviceCollection) {
        this.deviceCollection = deviceCollection;
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
        if (!(object instanceof DeviceRoom)) {
            return false;
        }
        DeviceRoom other = (DeviceRoom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cuongdn.dbs.DeviceRoom[ id=" + id + " ]";
    }
    
}
