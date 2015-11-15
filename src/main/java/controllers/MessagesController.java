package controllers;

import ViewModels.MessageViewModel;
import ViewModels.UserViewModel;
import forms.MessageForm;
import handlers.MessageHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;

/**
 * Created by dario on 2015-11-12.
 */
@ManagedBean
public class MessagesController {

    @ManagedProperty(value="#{messageForm}")
    private MessageForm messageForm;

    private ArrayList<MessageViewModel> messages;

    public MessageForm getMessageForm() {
        return messageForm;
    }

    public void setMessageForm(MessageForm messageForm) {
        this.messageForm = messageForm;
    }

    public ArrayList<MessageViewModel> getPrivateMessages(UserViewModel currentUser){

        return MessageHandler.getAllMessages(currentUser.getId());
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

    public String createUserMessage(){
        // takes a messageForm a sends a messageViewModel
        System.out.println("Subject: " + messageForm.getSubject());
        System.out.println("Content: " + messageForm.getContent());

        MessageHandler.createMessage(messageForm);

        return "index";
    }
}
