package models;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by dario on 2015-11-04.
 */
@Entity
@Table(name = "user")
@Access(AccessType.FIELD)
@NamedQuery(
        name="findAllUsersByName",
        query="SELECT OBJECT(user) FROM User user WHERE user.firstName like :firstName"
)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String passwordConfirmation;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    private String nickname;


    @OneToMany(mappedBy="sender", targetEntity = Message.class, fetch = FetchType.EAGER)
    private Collection<Message> sendMessages;

    @OneToMany(mappedBy="receiver", targetEntity = Message.class, fetch = FetchType.EAGER)
    private Collection<Message> receivedMessages;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Collection<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(Collection<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public Collection<Message> getSendMessages() {
        return sendMessages;
    }

    public void setSendMessages(Collection<Message> sendMessages) {
        this.sendMessages = sendMessages;
    }
}
