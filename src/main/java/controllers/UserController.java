package controllers;

import ViewModels.UserViewModel;
import forms.UserForm;
import handlers.MessageHandler;
import handlers.UserHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Created by dario on 2015-11-11.
 */
@ManagedBean
public class UserController {

    @ManagedProperty(value="#{userForm}")
    private UserForm userForm;

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

    public String getUserProfile(){
        int userProfileId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));

        System.out.println("USERPROFILEID ==============" + userProfileId);

        MessageHandler.getAllMessages(userProfileId);

        return "userProfile";
    }


}
