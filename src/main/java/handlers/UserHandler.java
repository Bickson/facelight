package handlers;

import dao.UserDAO;
import models.User;

/**
 * Created by dario on 2015-11-09.
 */
public class UserHandler {

    private static UserDAO userDAO = new UserDAO();

    public static User authenticateUser(String email, String password){
        //return user info
        return userDAO.authenticateUser(email,password);
    }

    public static User createUser(User user){

        return userDAO.create(user);
    }
}
