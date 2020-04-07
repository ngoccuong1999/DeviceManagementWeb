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
public class DeviceRoomBLO implements Serializable{

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
    public DeviceRoom findById(int id) {
        
        EntityManager em = emf.createEntityManager();
        String jqpl = "DeviceRoom.findById";
        Query query = em.createNamedQuery(jqpl);
        query.setParameter("id", id);
        DeviceRoom dev = (DeviceRoom)query.getSingleResult();
        return dev;
    }
    public boolean deleteRoom(int id) {
        EntityManager em = emf.createEntityManager();
        DeviceRoom devRoom = em.find(DeviceRoom.class, id);
        if(devRoom != null) {
            em.getTransaction().begin();
            em.remove(devRoom);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
    public boolean updateRoom(DeviceRoom devRoom) {
        EntityManager em = emf.createEntityManager();
        DeviceRoom x = em.find(DeviceRoom.class, devRoom.getId());
        if(x != null) {
            x.setName(devRoom.getName());
            em.getTransaction().begin();
            em.merge(x);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
    public boolean checkDuplicatedId(int id) {
        EntityManager em = emf.createEntityManager();
        
        DeviceRoom dev = em.find(DeviceRoom.class, id);
        if(dev != null) {
            return true;
        }
        return false;
    }
    public void insertDeviceRoom(DeviceRoom dev) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(dev);
        em.getTransaction().commit();
    }
    public List findAll() {
        EntityManager em = emf.createEntityManager();
        String jqpl = "DeviceRoom.findAll";
        Query query = em.createNamedQuery(jqpl);
        List result = query.getResultList();
        return result;
    }
}
