/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.dbs;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ngoc Cuong
 */
@Entity
@Table(name = "device_image", catalog = "DeviceManagement", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceImage.findAll", query = "SELECT d FROM DeviceImage d")
    , @NamedQuery(name = "DeviceImage.findById", query = "SELECT d FROM DeviceImage d WHERE d.id = :id")
    , @NamedQuery(name = "DeviceImage.findByLinkImage", query = "SELECT d FROM DeviceImage d WHERE d.linkImage = :linkImage")})
public class DeviceImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "link_image", nullable = false, length = 50)
    private String linkImage;
    @JoinColumn(name = "device_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Device deviceId;

    public DeviceImage() {
    }

    public DeviceImage(Integer id) {
        this.id = id;
    }

    public DeviceImage(Integer id, String linkImage) {
        this.id = id;
        this.linkImage = linkImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
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
        if (!(object instanceof DeviceImage)) {
            return false;
        }
        DeviceImage other = (DeviceImage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cuongdn.dbs.DeviceImage[ id=" + id + " ]";
    }
    
}
