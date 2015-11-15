package controllers;

import ViewModels.MessageViewModel;
import ViewModels.UserViewModel;
import handlers.MessageHandler;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

/**
 * Created by dario on 2015-11-12.
 */
@ManagedBean
public class MessagesController {

    private ArrayList<MessageViewModel> messages;

    public ArrayList<MessageViewModel> getPrivateMessages(UserViewModel currentUser){

        return messages;
    }

    public ArrayList<MessageViewModel> getMessages(UserViewModel currentUser)
    {
        //get from database
        System.out.println("------CURRENT USER: "+ currentUser.getFirstName());
        return MessageHandler.getAllMessages(currentUser.getId());
    }
    public void setMessages(ArrayList<MessageViewModel> messages) {
        this.messages = messages;
    }

    public void createUserMessage(MessageViewModel message){

    }
}
