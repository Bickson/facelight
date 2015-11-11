package handlers;

import controllers.*;
import dao.MessageDAO;
import dao.UserDAO;
import models.Message;
import models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dario on 2015-11-09.
 */
public class UserHandler {

    private static UserDAO userDAO = new UserDAO();

    public static UserBean authenticateUser(String email, String password){
        //return user info
        //WallBean wallBean = new WallBean();
        if(email.equals(null) || password.equals(null)){
            return null;
        }
        UserBean userBean = new UserBean();
        User user = userDAO.authenticateUser(email,password);
        if(user != null){
            //create userBean
            userBean.setId(user.getId());
            userBean.setFirstName(user.getFirstName());
            userBean.setLastName(user.getLastName());

            /*//create session user
            UserBean userBean = new UserBean(user.getFirstName(), user.getLastName());
            MessageDAO messageDAO = new MessageDAO();
            List<Message> receivedMessages = (List<Message>)messageDAO.getReceivedMessages(user.getId());
            List<Message> sendMessages = (List<Message>)messageDAO.getSendMessages(user.getId());
            ArrayList<MessageViewModel> userMessages = new ArrayList<>();

            for (Message m: receivedMessages){
                addMessageToMessageBean(userMessages, m);
            }
            for (Message m: sendMessages){
                addMessageToMessageBean(userMessages, m);
            }

            wallBean.setMessages(userMessages);
            wallBean.setCurrentUser(userBean);
            System.out.println("WALLBEAN MESSAGE SIZE:  " + wallBean.getMessages().size());*/
        }
        return userBean;
    }

/*    private static void addMessageToMessageBean(ArrayList<MessageViewModel> userMessages, Message m){
        MessageViewModel message = new MessageViewModel();
        UserViewModel sender = new UserViewModel(m.getSender().getFirstName(), m.getSender().getLastName());
        UserViewModel receiver = new UserViewModel(m.getReceiver().getFirstName(), m.getReceiver().getLastName());

        message.setType(m.getType());
        message.setSubject(m.getSubject());
        message.setContent(m.getContent());
        message.setReceiver(receiver);
        message.setSender(sender);
        System.out.println("MESSAGE FROM SAVE TO ARRAY: " + m.getSender().getFirstName());
        userMessages.add(message);
    }*/

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
