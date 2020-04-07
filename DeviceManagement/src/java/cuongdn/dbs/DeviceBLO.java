/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.dbs;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ngoc Cuong
 */
public class DeviceBLO implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeviceManagementPU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public boolean checkDuplicatedId(int id) {
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        String jpql = "Device.findById";
        Query query = em.createNamedQuery(jpql);
        query.setParameter("id", id);
        List dev = query.getResultList();
        if (!dev.isEmpty()) {
            check = true;
        }
        return check;
    }

    public void insertUser(Device dev) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(dev);
        em.getTransaction().commit();
    }

    public boolean deleteDevice(int id) {
        EntityManager em = emf.createEntityManager();
        Device dev = em.find(Device.class, id);
        if (dev != null) {
            dev.setStatus(3);
            em.getTransaction().begin();
            em.merge(dev);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    public Device searchById(int id) {
        EntityManager em = emf.createEntityManager();

        Device dev = em.find(Device.class, id);
        return dev;

    }

    public List findAll() {
        EntityManager em = emf.createEntityManager();
        String jpql = "Device.findAll";
        Query query = em.createNamedQuery(jpql);
        List result = query.getResultList();
        return result;
    }

    public void updateStatus(int id, int status) {
        EntityManager em = emf.createEntityManager();
        Device dev = em.find(Device.class, id);
        if (dev != null) {
            dev.setStatus(status);
            em.getTransaction().begin();
            em.merge(dev);
            em.getTransaction().commit();
        }
    }
    
    public boolean updateDevice(int id, String deviceName, String deviceDescription, String deviceType, DeviceRoom newRoom, int status) {
        EntityManager em = emf.createEntityManager();
        Device dev = em.find(Device.class, id);
        if (dev != null) {
            dev.setDeviceName(deviceName);
            dev.setStatus(status);
            dev.setDeviceDescription(deviceDescription);
            dev.setDeviceType(deviceType);
            dev.setDeviceRoomId(newRoom);
            em.getTransaction().begin();
            em.merge(dev);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
}
