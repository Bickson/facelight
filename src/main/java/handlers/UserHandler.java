package handlers;

import controllers.UserFormBean;
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

    public static User createUser(UserFormBean userFormBean){

        User user = new User();
        user.setFirstName(userFormBean.getFirstName());
        user.setLastName(userFormBean.getLastName());
        user.setEmail(userFormBean.getEmail());
        user.setPassword(userFormBean.getPassword());
        user.setPasswordConfirmation(userFormBean.getPasswordConfirmation());

        return userDAO.create(user);
    }
}
