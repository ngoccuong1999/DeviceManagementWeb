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
@Table(name = "device_fix", catalog = "DeviceManagement", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceFix.findAll", query = "SELECT d FROM DeviceFix d")
    , @NamedQuery(name = "DeviceFix.findById", query = "SELECT d FROM DeviceFix d WHERE d.id = :id")
    , @NamedQuery(name = "DeviceFix.findByRequestTime", query = "SELECT d FROM DeviceFix d WHERE d.requestTime = :requestTime")
    , @NamedQuery(name = "DeviceFix.findByRequestContent", query = "SELECT d FROM DeviceFix d WHERE d.requestContent = :requestContent")
    , @NamedQuery(name = "DeviceFix.findByTimeFixBegin", query = "SELECT d FROM DeviceFix d WHERE d.timeFixBegin = :timeFixBegin")
    , @NamedQuery(name = "DeviceFix.findByTimeFixFinish", query = "SELECT d FROM DeviceFix d WHERE d.timeFixFinish = :timeFixFinish")
    , @NamedQuery(name = "DeviceFix.findByResult", query = "SELECT d FROM DeviceFix d WHERE d.result = :result")})
public class DeviceFix implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "request_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestTime;
    @Basic(optional = false)
    @Column(name = "request_content", nullable = false, length = 50)
    private String requestContent;
    @Column(name = "time_fix_begin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeFixBegin;
    @Column(name = "time_fix_finish")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeFixFinish;
    @Basic(optional = false)
    @Column(name = "result", nullable = false)
    private boolean result;
    @JoinColumn(name = "device_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Device deviceId;
    @JoinColumn(name = "user_id", referencedColumnName = "username", nullable = false)
    @ManyToOne(optional = false)
    private UserInfo userId;
    @JoinColumn(name = "user_id_fix", referencedColumnName = "username", nullable = false)
    @ManyToOne(optional = false)
    private UserInfo userIdFix;

    public DeviceFix() {
    }

    public DeviceFix(Integer id) {
        this.id = id;
    }

    public DeviceFix(Integer id, Date requestTime, String requestContent, boolean result) {
        this.id = id;
        this.requestTime = requestTime;
        this.requestContent = requestContent;
        this.result = result;
    }

    public DeviceFix(Integer id, Date requestTime, String requestContent, Date timeFixBegin, Date timeFixFinish, boolean result, Device deviceId, UserInfo userId, UserInfo userIdFix) {
        this.id = id;
        this.requestTime = requestTime;
        this.requestContent = requestContent;
        this.timeFixBegin = timeFixBegin;
        this.timeFixFinish = timeFixFinish;
        this.result = result;
        this.deviceId = deviceId;
        this.userId = userId;
        this.userIdFix = userIdFix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public Date getTimeFixBegin() {
        return timeFixBegin;
    }

    public void setTimeFixBegin(Date timeFixBegin) {
        this.timeFixBegin = timeFixBegin;
    }

    public Date getTimeFixFinish() {
        return timeFixFinish;
    }

    public void setTimeFixFinish(Date timeFixFinish) {
        this.timeFixFinish = timeFixFinish;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
    }

    public UserInfo getUserId() {
        return userId;
    }

    public void setUserId(UserInfo userId) {
        this.userId = userId;
    }

    public UserInfo getUserIdFix() {
        return userIdFix;
    }

    public void setUserIdFix(UserInfo userIdFix) {
        this.userIdFix = userIdFix;
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
        if (!(object instanceof DeviceFix)) {
            return false;
        }
        DeviceFix other = (DeviceFix) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cuongdn.dbs.DeviceFix[ id=" + id + " ]";
    }
    
}
