package handlers;

import dao.MessageDAO;
import controllers.UserFormBean;
import dao.UserDAO;
import models.Message;
import models.User;

import java.util.List;

/**
 * Created by dario on 2015-11-09.
 */
public class UserHandler {

    private static UserDAO userDAO = new UserDAO();

    public static User authenticateUser(String email, String password){
        //return user info
        User user = userDAO.authenticateUser(email,password);
        if(user != null){
            MessageDAO messageDAO = new MessageDAO();
            List<Message> receivedMessages = (List<Message>)messageDAO.getReceivedMessages(user.getId());
            List<Message> sendMessages = (List<Message>)messageDAO.getSendMessages(user.getId());
        }

        return null;
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
