package models;

import dao.UserDAO;
import factories.UserFactory;
import org.junit.*;

import java.util.Collection;
import java.util.Iterator;


/**
 * Created by johan on 05/11/15.
 */

/*This class test that it is possible to:
Create User
Delete User
List User by name or all
Authenticate
* */
public class UserTest {

    private UserDAO userDAO = new UserDAO();
    private User user;

    @Before
    public void setUp(){
        //Save user
        user = userDAO.create(UserFactory.createUser());
        System.out.println("--> CREATED USER: " + user.getId());
    }

    @After
    public void tearDown(){
        //delete user
        System.out.println("--> DELETED USER: " + user.getId());
        userDAO.delete(user.getId());
    }

    @Test
    public void createUserFails(){
        System.out.println("-------------------CREATE_USER_FAILS-----------------");
        //Create user
        User failUser = userDAO.create(UserFactory.createUser());
        //Save user
        Assert.assertNull(failUser);
    }

    @Test
    public void loginSuccess(){
        System.out.println("-------------------LOGIN_SUCCESS---------------------");
        //User login
        User successUser = userDAO.authenticateUser(user.getEmail(),user.getPassword());
        Assert.assertEquals(user.getId(), successUser.getId());
    }
    @Test
    public void loginWrongPass(){
        System.out.println("-------------------LOGIN_WRONG_EMAIL-----------------");
        user.setPassword("fail");
        User failUser = userDAO.authenticateUser(user.getEmail(),user.getPassword());
        Assert.assertNull(failUser);
    }
    @Test
    public void loginWrongEmail(){
        System.out.println("-------------------LOGIN_WRONG_EMAIL-----------------");
        user.setEmail("fail@email.com");
        User failUser = userDAO.authenticateUser(user.getEmail(),user.getPassword());
        Assert.assertNull(failUser);
    }

    @Test
    public void listUsersByName(){
        System.out.println("---------------LIST_USERS_BY_NAME--------------------");
        //Create user and save
        User otherUser = userDAO.create(UserFactory.createUser("salomon@email.com", "mate"));

        //Create user and save
        User otherUser1 = userDAO.create(UserFactory.createUser("salo@email.com", "matti"));

        Collection users = userDAO.listUserByName("te");
        Assert.assertEquals(2,users.size());

        users = userDAO.listUserByName("tt");
        Assert.assertEquals(1,users.size());

        users = userDAO.listUsers();
        Assert.assertEquals(3,users.size());

        Iterator iter = users.iterator();
        while(iter.hasNext()){
            User u = (User) iter.next();
            System.out.println("----UserName: " + u.getFirstName());
        }

        userDAO.delete(otherUser.getId());
        userDAO.delete(otherUser1.getId());
    }

    @Test
    public void getUserByEmail(){
        Assert.assertNotNull(userDAO.getUserByEmail(user.getEmail()));
        user.setEmail("email.not.found@email.com");
        Assert.assertNull(userDAO.getUserByEmail(user.getEmail()));
    }
}
