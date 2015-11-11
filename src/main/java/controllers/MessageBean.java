package controllers;

import models.Message;
import models.MessageType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

/**
 * Created by johan on 10/11/15.
 */
@ManagedBean
@SessionScoped
public class MessageBean {

    private ArrayList<MessageViewModel> messages;

    public MessageBean(){

    }

    public ArrayList<MessageViewModel> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MessageViewModel> messages) {
        this.messages = messages;
    }

}
