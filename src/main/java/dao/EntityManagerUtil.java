package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by dario on 2015-11-05.
 */
public class EntityManagerUtil {

    private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("facelight");

    public static EntityManagerFactory getEntityManager(){
        return EMF;
    }
}
