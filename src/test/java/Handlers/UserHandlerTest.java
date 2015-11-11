package Handlers;

import controllers.MessageBean;
import controllers.WallBean;
import dao.MessageDAO;
import dao.UserDAO;
import factories.MessageFactory;
import factories.UserFactory;
import handlers.UserHandler;
import models.Message;
import models.User;
import org.junit.After;
import org.junit.Assert;
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
        /*//send a message 1
        message.setSender(sender);
        message.setReceiver(receiver);
        messages.add(messageDAO.create(message));

        //send a message 2
        Message msg2 = MessageFactory.createMessage();
        msg2.setSender(sender);
        msg2.setReceiver(receiver);
        messages.add(messageDAO.create(msg2));

        //send a message 3
        Message msg3 = MessageFactory.createMessage();
        msg3.setSender(sender);
        msg3.setReceiver(receiver);
        messages.add(messageDAO.create(msg3));

        WallBean wallBean = UserHandler.authenticateUser(sender.getEmail(), sender.getPassword());

        Assert.assertEquals("The number of messages have to be 3",3,wallBean.getMessages().size());
        Assert.assertEquals("sender", wallBean.getMessages().get(0).getSender().getFirstName());*/

    }
}
