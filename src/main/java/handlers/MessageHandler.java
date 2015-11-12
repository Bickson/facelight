package handlers;

import controllers.MessageViewModel;
import controllers.UserViewModel;
import dao.MessageDAO;
import models.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dario on 2015-11-11.
 */
public class MessageHandler {

    private static MessageDAO messageDAO = new MessageDAO();

    public static ArrayList<MessageViewModel> getAllMessages(int userId){

        ArrayList<MessageViewModel> userMessages = new ArrayList<>();
        List<Message> receivedMessages = (List<Message>)messageDAO.getReceivedMessages(userId);
        List<Message> sendMessages = (List<Message>)messageDAO.getSendMessages(userId);

        for (Message m: receivedMessages){
            addMessageToMessageBean(userMessages, m);
        }
        for (Message m: sendMessages){
            addMessageToMessageBean(userMessages, m);
        }
        return userMessages;
    }

    private static void addMessageToMessageBean(ArrayList<MessageViewModel> userMessages, Message m){
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
    }
}
