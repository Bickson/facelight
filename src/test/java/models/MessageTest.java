package models;


import dao.MessageDAO;
import dao.UserDAO;
import factories.MessageFactory;
import factories.UserFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;


/**
 * Created by dario on 2015-11-05.
 */
@SuppressWarnings("unchecked")
public class MessageTest {

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
    public void createMessageWithoutSender(){
        message.setReceiver(receiver);
        Assert.assertNull(messageDAO.create(message));    }

    @Test
    public void createMessageWithoutReceiver(){
        message.setSender(sender);
        Assert.assertNull(messageDAO.create(message));
    }

    @Test
    public void createMessageWithoutSubject(){
        message.setSender(sender);
        message.setReceiver(receiver);
        messages.add(messageDAO.create(message));
        Assert.assertNotNull(messages.get(0));
    }

    @Test
    public void createMessageWithoutContent(){
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(null);
        Assert.assertNull(messageDAO.create(message));
    }

    @Test
    public void createMessageWithoutType(){
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setType(null);
        Assert.assertNull(messageDAO.create(message));
    }

    @Test
    public void getReceivedMessages(){
        //send a message 1
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

        //send a message 4
        Message msg4 = MessageFactory.createMessage();
        msg4.setSender(sender);
        msg4.setReceiver(receiver);
        messages.add(messageDAO.create(msg4));

        //send a message 5
        Message msg5 = MessageFactory.createMessage();
        msg5.setSender(sender);
        msg5.setReceiver(receiver);
        messages.add(messageDAO.create(msg5));

        Collection receivedMessages = messageDAO.getReceivedMessages(receiver.getId());

        Assert.assertEquals(5,receivedMessages.size());

        ArrayList<Message> messageList = new ArrayList<>();
        receivedMessages.forEach(msg -> messageList.add((Message) msg));

        messageList.forEach(msg -> Assert.assertEquals(sender.getId(), msg.getSender().getId()));
    }

    @Test
    public void getSendMessages(){
        //send a message 1
        message.setSender(sender);
        message.setReceiver(receiver);
        messages.add(messageDAO.create(message));

        //send a message 2
        Message msg2 = MessageFactory.createMessage();
        extraUsers.add(userDAO.create(UserFactory.createUser("new.receiver@email.com","new.receiver")));
        msg2.setSender(sender);
        msg2.setReceiver(extraUsers.get(0));
        messages.add(messageDAO.create(msg2));

        Assert.assertEquals(2, messageDAO.getSendMessages(sender.getId()).size());
        Assert.assertEquals(1, messageDAO.getReceivedMessages(extraUsers.get(0).getId()).size());
    }

    @Test
    public void getAllMessagesOrderBy(){
        //send a message 1
        message.setSender(sender);
        message.setReceiver(receiver);
        messages.add(messageDAO.create(message));

        //send a message 2
        Message msg2 = MessageFactory.createMessage();
        extraUsers.add(userDAO.create(UserFactory.createUser("new.receiver@email.com","new.receiver")));
        msg2.setSender(sender);
        msg2.setReceiver(extraUsers.get(0));
        messages.add(messageDAO.create(msg2));

        //send a message 3
        Message msg3 = MessageFactory.createMessage();
        msg3.setSender(receiver);
        msg3.setReceiver(sender);//sender got a msg
        messages.add(messageDAO.create(msg3));

        //send a message 4
        Message msg4 = MessageFactory.createMessage();
        msg4.setSender(extraUsers.get(0));
        msg4.setReceiver(sender);//sender got a msg
        messages.add(messageDAO.create(msg4));

        ArrayList<Message> allMessages = new ArrayList<>();
        messageDAO.getSendMessages(sender.getId())
                .forEach(msg -> allMessages.add((Message) msg));
        messageDAO.getReceivedMessages(sender.getId())
                .forEach(msg -> allMessages.add((Message) msg));

        allMessages.forEach(msg -> System.out.println("Created at: " + msg.getCreatedAt()));

        Assert.assertEquals(4, allMessages.size());


    }

}
