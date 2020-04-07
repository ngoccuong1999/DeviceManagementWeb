/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.dbs;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ngoc Cuong
 */
public class AnnoucementBLO implements Serializable{

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
        Annoucement usi = em.find(Annoucement.class, id);
        if(usi != null) {
            check = true;
        } 
        return check;
    }
    public void insert(Annoucement annou) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(annou);
        em.getTransaction().commit();
    }
    public void updateStatus(int id, int status) {
        EntityManager em = emf.createEntityManager();
        Annoucement x = em.find(Annoucement.class, id);
        x.setStatus(status);
        em.getTransaction().begin();
        em.merge(x);
        em.getTransaction().commit();
    }
}
