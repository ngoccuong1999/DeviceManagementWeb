/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.dbs;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ngoc Cuong
 */
@Entity
@Table(name = "device_position", catalog = "DeviceManagement", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DevicePosition.findAll", query = "SELECT d FROM DevicePosition d")
    , @NamedQuery(name = "DevicePosition.findById", query = "SELECT d FROM DevicePosition d WHERE d.id = :id")
    , @NamedQuery(name = "DevicePosition.findByNo", query = "SELECT d FROM DevicePosition d WHERE d.no = :no")
    , @NamedQuery(name = "DevicePosition.findByChangeTime", query = "SELECT d FROM DevicePosition d WHERE d.changeTime = :changeTime")
    , @NamedQuery(name = "DevicePosition.findByChangeReason", query = "SELECT d FROM DevicePosition d WHERE d.changeReason = :changeReason")})
public class DevicePosition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "no")
    private Integer no;
    @Column(name = "change_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changeTime;
    @Column(name = "change_reason", length = 50)
    private String changeReason;
    @JoinColumn(name = "device_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Device deviceId;
    @JoinColumn(name = "device_room_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private DeviceRoom deviceRoomId;
    @JoinColumn(name = "user_id", referencedColumnName = "username")
    @ManyToOne
    private UserInfo userId;

    public DevicePosition() {
    }

    public DevicePosition(Integer id, Integer no, Date changeTime, String changeReason, Device deviceId, DeviceRoom deviceRoomId, UserInfo userId) {
        this.id = id;
        this.no = no;
        this.changeTime = changeTime;
        this.changeReason = changeReason;
        this.deviceId = deviceId;
        this.deviceRoomId = deviceRoomId;
        this.userId = userId;
    }
    
    public DevicePosition(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
    }

    public DeviceRoom getDeviceRoomId() {
        return deviceRoomId;
    }

    public void setDeviceRoomId(DeviceRoom deviceRoomId) {
        this.deviceRoomId = deviceRoomId;
    }

    public UserInfo getUserId() {
        return userId;
    }

    public void setUserId(UserInfo userId) {
        this.userId = userId;
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
        if (!(object instanceof DevicePosition)) {
            return false;
        }
        DevicePosition other = (DevicePosition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cuongdn.dbs.DevicePosition[ id=" + id + " ]";
    }
    
}
