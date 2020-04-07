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
public class DevicePositionBLO implements Serializable {

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

    public boolean checkByIdAndNo(Device deviceId, int no) {
        EntityManager em = emf.createEntityManager();
        String jpql = "Select d From DevicePosition d where d.deviceId.id = :id And d.no = :no";
        Query query = em.createQuery(jpql);
        query.setParameter("id", deviceId.getId());
        query.setParameter("no", no);
        List devPosition = query.getResultList();
        if(!devPosition.isEmpty()) {
            return true;
        }
        return false;
    }
    public boolean checkDuplicatedId(int id) {
        EntityManager em = emf.createEntityManager();
        DevicePosition devPosition = em.find(DevicePosition.class, id);
        if(devPosition != null) {
            return true;
        }
        return false;
        
    }
    public void insert(DevicePosition devPosition) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(devPosition);
        em.getTransaction().commit();
        
    }
}
