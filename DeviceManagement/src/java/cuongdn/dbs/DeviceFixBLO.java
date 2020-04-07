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
public class DeviceFixBLO implements Serializable{

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
    public List findByDeviceAndUser(String username, int deviceId) {
        EntityManager em = emf.createEntityManager();
        String jpql = "Select d From DeviceFix d Where d.deviceId.id = :id And d.userId.username = :username";
        Query query = em.createQuery(jpql);
        query.setParameter("id", deviceId);
        query.setParameter("username", username);
        List deviceFix = (List) query.getResultList();
        return deviceFix;
    }
    public boolean checkDuplicatedId(int id) {
        EntityManager em = emf.createEntityManager();
        DeviceFix devFix = em.find(DeviceFix.class, id);
        if(devFix != null) {
            return true;
        } 
        return false;
    }
    public void insertDeviceFix(DeviceFix devFix) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(devFix);
        em.getTransaction().commit();
    }
}
