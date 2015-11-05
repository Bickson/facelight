package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by johan on 05/11/15.
 */
public class UserTest {

    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setUpFactory(){
        emf = Persistence.createEntityManagerFactory("facelight");
        em = emf.createEntityManager();
    }

    @After
    public void closeFactory(){
        em.close();
        emf.close();
    }

    @Test
    public void testString(){

    }
}
