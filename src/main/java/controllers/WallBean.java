package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by johan on 10/11/15.
 */
@ManagedBean
@RequestScoped
public class WallBean {

    @ManagedProperty(value="UserBean")
    private UserBean user;

    @ManagedProperty(value="MessageBean")
    private MessageBean[] messages;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public MessageBean[] getMessages() {
        return messages;
    }

    public void setMessages(MessageBean[] messages) {
        this.messages = messages;
    }

}
