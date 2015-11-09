package handlers;

import dao.UserDAO;
import models.User;

/**
 * Created by dario on 2015-11-09.
 */
public class UserHandler {

    private static UserDAO userDAO = new UserDAO();

    public static User authenticateUser(String email, String password){
        return userDAO.authenticateUser(email,password);
    }
}
