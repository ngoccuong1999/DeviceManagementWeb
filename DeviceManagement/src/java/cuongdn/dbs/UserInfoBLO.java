/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuongdn.dbs;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import cuongdn.dbs.UserInfo;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ngoc Cuong
 */
public class UserInfoBLO implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeviceManagementPU");

    public int checkLogin(String username, String password) {
        int role = 0;
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT u.role FROM UserInfo u WHERE u.username = :username AND u.password = :password";
        Query query = em.createQuery(jpql);

        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            role = (int) query.getSingleResult();
            return role;
        } catch (NoResultException e) {
            return role;
        }
    }
    public boolean checkDuplicatedId(String id) {
        boolean check = false;
        EntityManager em = emf.createEntityManager();
        UserInfo usi = em.find(UserInfo.class, id);
        if(usi != null) {
            check = true;
        } 
        return check;
    }
    public DeviceRoom findDeviceRoomId(String id) {
        int deviceRoomId = 0;
        EntityManager em = emf.createEntityManager();
        UserInfo usi = em.find(UserInfo.class, id);
        
        return usi.getDeviceRoomId();
    }
    public void insertUser(UserInfo usi) {
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usi);
        em.getTransaction().commit();
        
    }
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
    public UserInfo findById(String id) {
        EntityManager em = emf.createEntityManager();
        UserInfo usi = em.find(UserInfo.class, id);
        return usi;
    }
    public boolean delete(String id) {
        EntityManager em = emf.createEntityManager();
        UserInfo usi = em.find(UserInfo.class, id);
        if(usi != null) {
            em.getTransaction().begin();
            em.remove(usi);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
    public List findExceptUser(){
        EntityManager em = emf.createEntityManager();
        String jpql = "Select u From UserInfo u Where u.role > :role";
        Query query = em.createQuery(jpql);
        query.setParameter("role", 1);
        List result = query.getResultList();
        return result;
    }
    public List findAll() {
        EntityManager em = emf.createEntityManager();
        String jqpl = "UserInfo.findAll";
        Query query = em.createNamedQuery(jqpl);
        List result = query.getResultList();
        return result;
    }
    public boolean updateUser(UserInfo usi, String id) {
        EntityManager em = emf.createEntityManager();
        UserInfo x = em.find(UserInfo.class, id);
        if(x != null) {
            x = usi;
            em.getTransaction().begin();
            em.merge(x);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
    public UserInfo findByUserName(String username) {
        EntityManager em = emf.createEntityManager();
        String jpql = "UserInfo.findByUsername";
        Query query = em.createNamedQuery(jpql);
        query.setParameter("username", username);
        UserInfo usi = (UserInfo)query.getSingleResult();
        return usi;
    }
}
