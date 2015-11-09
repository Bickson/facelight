package dao;

import dao.generics.GenericDaoImpl;
import models.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by dario on 2015-11-06.
 */
public class UserDAO extends GenericDaoImpl<User> {

    public User getUser(int id){
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        User user = null;
        try{
            user = em.find(User.class, id);
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        return user;
    }

    public Collection listUsers(){
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        Collection result = null;
        try{
            result = em.createQuery("select user from User user").getResultList();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        return result;
    }

    public Collection listUserByName(String userName){
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        userName = "%"+userName+"%";
        Collection users = null;
        try{
            Query usersByName = em.createNamedQuery("findAllUsersByName");
            users = usersByName.setParameter("firstName", userName)
                    .getResultList();
        }catch (NoResultException ex){
            System.out.println(ex.getMessage());
        }finally {
            em.close();
        }
        return users;
    }

    public User authenticateUser(String email, String password ){
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        User authenticatedUser = null;
        try {
            authenticatedUser = (User) em.createQuery("select user from User user " +
                    "where user.email = ?1 and user.password = ?2")
                    .setParameter(1, email)
                    .setParameter(2, password).getSingleResult();
        }catch (NoResultException ex){
            System.out.println(ex.getMessage());
        }finally {
            em.close();
        }
        return authenticatedUser;
    }

    public User getUserByEmail(String email){
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        User user = null;
        try {
            user =  (User) em.createQuery("select user from User user " +
                    "where user.email = ?1")
                    .setParameter(1, email)
                    .getSingleResult();
        }catch (NoResultException ex){
            System.out.println(ex.getMessage());
        }finally {
            em.close();
        }
        return user;
    }
}
