/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.dbs;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ngoc Cuong
 */
@Entity
@Table(name = "user_info", catalog = "DeviceManagement", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInfo.findAll", query = "SELECT u FROM UserInfo u")
    , @NamedQuery(name = "UserInfo.findByUsername", query = "SELECT u FROM UserInfo u WHERE u.username = :username")
    , @NamedQuery(name = "UserInfo.findByPassword", query = "SELECT u FROM UserInfo u WHERE u.password = :password")
    , @NamedQuery(name = "UserInfo.findByFullName", query = "SELECT u FROM UserInfo u WHERE u.fullName = :fullName")
    , @NamedQuery(name = "UserInfo.findByPhoneNumber", query = "SELECT u FROM UserInfo u WHERE u.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "UserInfo.findByOnline", query = "SELECT u FROM UserInfo u WHERE u.online = :online")
    , @NamedQuery(name = "UserInfo.findByRole", query = "SELECT u FROM UserInfo u WHERE u.role = :role")})
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Column(name = "full_name", length = 50)
    private String fullName;
    @Basic(optional = false)
    @Column(name = "phone_number", nullable = false, length = 50)
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "online", nullable = false)
    private boolean online;
    @Basic(optional = false)
    @Column(name = "role", nullable = false)
    private int role;
    @ManyToMany(mappedBy = "userInfoCollection")
    private Collection<Annoucement> annoucementCollection;
    @JoinColumn(name = "device_room_id", referencedColumnName = "id")
    @ManyToOne
    private DeviceRoom deviceRoomId;

    public UserInfo() {
    }

    public UserInfo(String username) {
        this.username = username;
    }

    public UserInfo(String username, String password, String fullName, String phoneNumber, boolean online, int role, DeviceRoom deviceRoomId) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.online = online;
        this.role = role;
        this.deviceRoomId = deviceRoomId;
    }
    
    public UserInfo(String username, String password, String phoneNumber, boolean online, int role) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.online = online;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<Annoucement> getAnnoucementCollection() {
        return annoucementCollection;
    }

    public void setAnnoucementCollection(Collection<Annoucement> annoucementCollection) {
        this.annoucementCollection = annoucementCollection;
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
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cuongdn.dbs.UserInfo[ username=" + username + " ]";
    }
    
}
