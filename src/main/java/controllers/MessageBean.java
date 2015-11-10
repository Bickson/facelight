package controllers;

import models.MessageType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by johan on 10/11/15.
 */
@ManagedBean
@RequestScoped
public class MessageBean {

    private MessageType type;
    private String subject;
    private String content;
    private String createdAt;

    @ManagedProperty(value="UserBean")
    private UserBean receiver;

    @ManagedProperty(value="UserBean")
    private UserBean sender;

    public UserBean getSender() {
        return sender;
    }

    public void setSender(UserBean sender) {
        this.sender = sender;
    }

    public UserBean getReceiver() {
        return receiver;
    }

    public void setReceiver(UserBean receiver) {
        this.receiver = receiver;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


}
