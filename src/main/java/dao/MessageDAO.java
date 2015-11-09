package dao;

import dao.generics.GenericDaoImpl;
import models.Message;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Collection;

/**
 * Created by dario on 2015-11-07.
 */
public class MessageDAO extends GenericDaoImpl<Message> {

    public Collection getReceivedMessages(int userId){
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        Collection receivedMessages = null;
        try{
            receivedMessages = em.createQuery("select message from Message message" +
                    " where message.receiver.id = ?1" +
                    " order by message.createdAt")
                    .setParameter(1,userId)
                    .getResultList();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        return receivedMessages;
    }

    public Collection getSendMessages(int userId){
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        Collection receivedMessages = null;
        try{
            receivedMessages = em.createQuery("select message from Message message" +
                    " where message.sender.id = ?1" +
                    " order by message.createdAt")
                    .setParameter(1,userId)
                    .getResultList();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        return receivedMessages;
    }

}
