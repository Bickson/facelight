package dao.generics;

import dao.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by dario on 2015-11-08.
 */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    private Class<T> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(final T t) {
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        T entityCreated = null;
        EntityTransaction transaction = null;
        try{
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(t);
            transaction.commit();
            entityCreated = t;
        }catch (Exception e){
            System.err.println("-------- "+ e.getMessage()+" --------");
            if(transaction != null && transaction.isActive())
                transaction.rollback();
        }finally {
            em.close();
        }
        return entityCreated;
    }

    @Override
    public boolean delete(final Object id) {
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        boolean deleted = false;
        try{
            T entity = em.find(type, id);
            if(entity != null){
                em.getTransaction().begin();
                em.remove(entity);
                em.getTransaction().commit();
                deleted = true;
            }
        }catch (Exception e){
            System.err.println("-------- "+ e.getMessage()+" --------");        }
        finally {
            em.close();
        }
        return deleted;
    }

    @Override
    public T find(final Object id) {
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        return em.find(type, id);
    }

    @Override
    public T update(final T t) {
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        return em.merge(t);
    }

}
