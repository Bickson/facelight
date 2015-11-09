package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dario on 2015-11-04.
 */
@Entity
@Table(name = "message")
@Access(AccessType.FIELD)
public class Message implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private MessageType type;

    @Column(nullable = true)
    private String subject;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    //@Temporal(TemporalType.DATE)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name="receiverId", nullable=false, foreignKey = @ForeignKey(name = "FK_RECEIVER"))
    private User receiver;

    @ManyToOne
    @JoinColumn(name="senderId", nullable=false, foreignKey = @ForeignKey(name = "FK_SENDER"))
    private User sender;

    public int getId() {
        return id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getReceiver() { return receiver; }

    public void setReceiver(User receiver){
        this.receiver = receiver;
    }

    public User getSender() { return sender; }

    public void setSender(User sender) {
        this.sender = sender;
    }

}
