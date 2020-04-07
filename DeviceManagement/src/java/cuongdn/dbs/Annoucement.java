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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "annoucement", catalog = "DeviceManagement", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annoucement.findAll", query = "SELECT a FROM Annoucement a")
    , @NamedQuery(name = "Annoucement.findById", query = "SELECT a FROM Annoucement a WHERE a.id = :id")
    , @NamedQuery(name = "Annoucement.findByAnnoucementContent", query = "SELECT a FROM Annoucement a WHERE a.annoucementContent = :annoucementContent")
    , @NamedQuery(name = "Annoucement.findByTime", query = "SELECT a FROM Annoucement a WHERE a.time = :time")
    , @NamedQuery(name = "Annoucement.findByUserIdRequest", query = "SELECT a FROM Annoucement a WHERE a.userIdRequest = :userIdRequest")
    , @NamedQuery(name = "Annoucement.findByDeviceIdRequest", query = "SELECT a FROM Annoucement a WHERE a.deviceIdRequest = :deviceIdRequest")
    , @NamedQuery(name = "Annoucement.findByStatus", query = "SELECT a FROM Annoucement a WHERE a.status = :status")})
public class Annoucement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "annoucement_content", nullable = false, length = 100)
    private String annoucementContent;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @Column(name = "user_id_request", nullable = false, length = 50)
    private String userIdRequest;
    @Basic(optional = false)
    @Column(name = "device_id_request", nullable = false)
    private int deviceIdRequest;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private int status;
    @JoinTable(name = "user_has_annoucement", joinColumns = {
        @JoinColumn(name = "annoucement_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "username", nullable = false)})
    @ManyToMany
    private Collection<UserInfo> userInfoCollection;

    public Annoucement() {
    }

    public Annoucement(Integer id) {
        this.id = id;
    }

    public Annoucement(Integer id, String annoucementContent, String userIdRequest, int deviceIdRequest, int status) {
        this.id = id;
        this.annoucementContent = annoucementContent;
        this.userIdRequest = userIdRequest;
        this.deviceIdRequest = deviceIdRequest;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Annoucement(Integer id, String annoucementContent, Date time, String userIdRequest, int deviceIdRequest, int status, Collection<UserInfo> userInfoCollection) {
        this.id = id;
        this.annoucementContent = annoucementContent;
        this.time = time;
        this.userIdRequest = userIdRequest;
        this.deviceIdRequest = deviceIdRequest;
        this.status = status;
        this.userInfoCollection = userInfoCollection;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnnoucementContent() {
        return annoucementContent;
    }

    public void setAnnoucementContent(String annoucementContent) {
        this.annoucementContent = annoucementContent;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserIdRequest() {
        return userIdRequest;
    }

    public void setUserIdRequest(String userIdRequest) {
        this.userIdRequest = userIdRequest;
    }

    public int getDeviceIdRequest() {
        return deviceIdRequest;
    }

    public void setDeviceIdRequest(int deviceIdRequest) {
        this.deviceIdRequest = deviceIdRequest;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<UserInfo> getUserInfoCollection() {
        return userInfoCollection;
    }

    public void setUserInfoCollection(Collection<UserInfo> userInfoCollection) {
        this.userInfoCollection = userInfoCollection;
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
        if (!(object instanceof Annoucement)) {
            return false;
        }
        Annoucement other = (Annoucement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cuongdn.dbs.Annoucement[ id=" + id + " ]";
    }
    
}
