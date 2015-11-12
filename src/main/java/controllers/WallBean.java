package controllers;

import java.util.ArrayList;

/**
 * Created by johan on 10/11/15.
 */
public class WallBean {

    private ArrayList<MessageViewModel> messages;

    public ArrayList<MessageViewModel> getMessages()
    {
        return messages;
    }

    public void setMessages(ArrayList<MessageViewModel> messages) {
        this.messages = messages;
    }

}
