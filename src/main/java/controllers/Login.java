package controllers;

import javafx.beans.DefaultProperty;
import models.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Created by johan on 10/11/15.
 */
@ManagedBean(name="login")
@SessionScoped
public class Login {

    @ManagedProperty(value="#{loginForm}")
    private LoginForm loginForm;

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    public String doLogin(){
        User user = handlers.UserHandler.authenticateUser(loginForm.getEmail(), loginForm.getPassword());
        System.out.println("Trying to loggin!");

        if(user != null) return "index";
        return "register";
    }
}
