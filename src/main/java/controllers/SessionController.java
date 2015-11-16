package controllers;

import ViewModels.UserViewModel;
import forms.LoginForm;
import handlers.UserHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Created by dario on 2015-11-12.
 */
@ManagedBean
@SessionScoped
public class SessionController {

    @ManagedProperty(value="#{loginForm}")
    private LoginForm loginForm;
    private UserViewModel currentUser;
    private UserViewModel remoteUser;

    public SessionController(){
        currentUser = new UserViewModel();
        remoteUser = new UserViewModel();
    }

    //Getter & Setter
    public UserViewModel getRemoteUser() {
        return remoteUser;
    }
    public void setRemoteUser(UserViewModel remoteUser) {
        this.remoteUser = remoteUser;
    }
    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    public UserViewModel getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserViewModel currentUser) {
        this.currentUser = currentUser;
    }

    //Methods
    public String doLogin(){
        currentUser = UserHandler.authenticateUser(loginForm.getEmail(), loginForm.getPassword());
        if(currentUser != null){
            return "index";
        }
        return "register";
    }
}
