package handlers;

import ViewModels.MessageViewModel;
import ViewModels.UserViewModel;
import dao.MessageDAO;
import dao.UserDAO;
import models.Message;
import models.MessageType;
import models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dario on 2015-11-11.
 */
public class MessageHandler {

    private static MessageDAO messageDAO = new MessageDAO();
    private static UserDAO userDAO = new UserDAO();

    public static ArrayList<MessageViewModel> getAllMessages(int userId){
        //Fix return just PUBLIC MESSAGES
        ArrayList<MessageViewModel> userMessages = new ArrayList<>();
        List<Message> receivedMessages = (List<Message>)messageDAO.getReceivedMessages(userId);
        List<Message> sendMessages = (List<Message>)messageDAO.getSendMessages(userId);

        receivedMessages
                .stream()
                .filter(m -> m.getType().equals(MessageType.PUBLIC))
                .forEach(m -> addMessageToMessageBean(userMessages, m));

        sendMessages
                .stream()
                .filter(m -> m.getType().equals(MessageType.PUBLIC))
                .forEach(m -> addMessageToMessageBean(userMessages, m));

        return userMessages;
    }

    public static ArrayList<MessageViewModel> getPrivateMessages(UserViewModel user){
        ArrayList<MessageViewModel> userMessages = new ArrayList<>();
        List<Message> receivedMessages = (List<Message>)messageDAO.getReceivedMessages(user.getId());
        List<Message> sendMessages = (List<Message>)messageDAO.getSendMessages(user.getId());

        receivedMessages
                .stream()
                .filter(m -> m.getType().equals(MessageType.PRIVATE))
                .forEach(m -> addMessageToMessageBean(userMessages, m));

        sendMessages
                .stream()
                .filter(m -> m.getType().equals(MessageType.PRIVATE))
                .forEach(m -> addMessageToMessageBean(userMessages, m));

        return userMessages;
    }

    public static boolean createMessage(MessageViewModel message){

        User sender = userDAO.getUser(message.getSender().getId());
        User receiver = userDAO.getUser(message.getReceiver().getId());

        Message messageNew = new Message();
        messageNew.setSender(sender);
        messageNew.setReceiver(receiver);
        messageNew.setSubject(message.getSubject());
        messageNew.setContent(message.getContent());
        messageNew.setCreatedAt(new Date());
        Message created = messageDAO.create(messageNew);

        return (created != null);
    }

    private static void addMessageToMessageBean(ArrayList<MessageViewModel> userMessages, Message m){
        MessageViewModel message = new MessageViewModel();
        UserViewModel sender = new UserViewModel(m.getId(),m.getSender().getFirstName(), m.getSender().getLastName());
        UserViewModel receiver = new UserViewModel(m.getId(),m.getReceiver().getFirstName(), m.getReceiver().getLastName());

        message.setType(m.getType());
        message.setSubject(m.getSubject());
        message.setContent(m.getContent());
        message.setReceiver(receiver);
        message.setSender(sender);
        //Format message
        message.setCreatedAt(m.getCreatedAt().toString());
        System.out.println("MESSAGE FROM SAVE TO ARRAY: " + m.getSender().getFirstName());
        userMessages.add(message);
    }

}
