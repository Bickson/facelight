package controllers;

import forms.UserForm;
import handlers.UserHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 * Created by dario on 2015-11-11.
 */
@ManagedBean
public class UserController {

    @ManagedProperty(value="#{userForm}")
    private UserForm userForm;

    public UserController(){

    }


    public UserForm getUserForm() {
        return userForm;
    }

    public void setUserForm(UserForm userForm) {
        this.userForm = userForm;
    }


    //Methods
    public String registerUser(){

        if(UserHandler.createUser(userForm) != null){
            return "login";
        }
        return "register";
    }

}
