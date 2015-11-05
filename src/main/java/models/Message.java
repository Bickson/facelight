package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by dario on 2015-11-04.
 */
@Entity
public class Message {

    @NotNull
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private MessageType type;

    private String subject;

    @NotNull
    private String content;

    @NotNull
    private Date createdAt;


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
}
