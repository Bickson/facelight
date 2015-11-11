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

    @ManagedProperty(value="#{wallBean}")
    private WallBean wallBean;

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    public String doLogin(){
        /*wallBean = handlers.UserHandler.authenticateUser(loginForm.getEmail(), loginForm.getPassword());
        System.out.println("Trying to loggin!");
        if(wallBean != null){
            System.out.println("-----USER HANDLER RETURNED: ");
            System.out.println("-----MESSAGES: " + wallBean.getMessages().size());
            System.out.println("-----CURRENT USER: " + wallBean.getCurrentUser().getFirstName());
            System.out.println("-----FIRST MESSAGE FROM: " + wallBean.getMessages().get(0).getSender().getFirstName());
            return "index";
        }*/
        return "register";
    }

    public WallBean getWallBean() {
        return wallBean;
    }

    public void setWallBean(WallBean wallBean) {
        this.wallBean = wallBean;
    }
}
