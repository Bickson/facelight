package controllers;

import models.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by johan on 09/11/15.
 */
@ManagedBean(name="user")
@SessionScoped
public class UserBean implements Serializable {

    private String email;
    private String password;

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public String login(){
        User user = UserHandler.authenticateUser();

        if(user){
            return "index";
        }
        return "login";
    }

}