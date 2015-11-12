package Handlers;

import dao.MessageDAO;
import dao.UserDAO;
import factories.MessageFactory;
import factories.UserFactory;
import models.Message;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

/**
 * Created by dario on 2015-11-10.
 */
public class UserHandlerTest {

    private MessageDAO messageDAO = new MessageDAO();
    private UserDAO userDAO = new UserDAO();
    private User sender;
    private User receiver;
    private Message message;
    private Vector<User> extraUsers = new Vector<>();
    private Vector<Message> messages = new Vector<>();

    @Before
    public void setUp(){
        sender = userDAO.create(UserFactory.createUser("sender@email.com","sender"));
        receiver = userDAO.create(UserFactory.createUser("receiver@email.com","receiver"));
        message = MessageFactory.createMessage();

    }

    @After
    public void tearDown(){
        //Delete all the messages
        messages.forEach(msg -> messageDAO.delete(msg.getId()));
        extraUsers.forEach(usr -> userDAO.delete(usr.getId()));
        userDAO.delete(sender.getId());
        userDAO.delete(receiver.getId());
    }

    @Test
    public void authenticateUser(){


    }
}
