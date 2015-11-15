package Handlers;

import ViewModels.MessageViewModel;
import ViewModels.UserViewModel;
import dao.MessageDAO;
import dao.UserDAO;
import factories.MessageFactory;
import factories.UserFactory;
import handlers.MessageHandler;
import models.Message;
import models.MessageType;
import models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

/**
 * Created by dario on 2015-11-12.
 */
public class MessageHandlerTest {

    private MessageDAO messageDAO = new MessageDAO();
    private UserDAO userDAO = new UserDAO();
    private User sender;
    private User receiver;
    private Vector<User> extraUsers = new Vector<>();
    private Vector<Message> messages = new Vector<>();

    @Before
    public void setUp(){
        sender = userDAO.create(UserFactory.createUser("sender@email.com","sender"));
        receiver = userDAO.create(UserFactory.createUser("receiver@email.com","receiver"));

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
    public  void createMessage(){

        Assert.assertTrue(MessageHandler.createMessage(createMessageViewModel()));
    }

    private MessageViewModel createMessageViewModel(){
        MessageViewModel message = new MessageViewModel();
        message.setReceiver(new UserViewModel(receiver.getId(), receiver.getFirstName(), receiver.getLastName()));
        message.setSender(new UserViewModel(sender.getId(), sender.getFirstName(), sender.getLastName()));
        message.setSubject("Test");
        message.setContent("Test body!");
        message.setType(MessageType.PUBLIC);
        return message;
    }
}
