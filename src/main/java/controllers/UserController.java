package controllers;

import handlers.MessageHandler;
import handlers.UserHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Created by dario on 2015-11-11.
 */
@ManagedBean
@SessionScoped
public class UserController {

    @ManagedProperty(value="#{loginForm}")
    private LoginForm loginForm;

    private UserBean currentUser;

    private WallBean wallBean;

    public UserController(){
        this.wallBean = new WallBean();
        this.currentUser = new UserBean();
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    public String doLogin(){
        currentUser = UserHandler.authenticateUser(loginForm.getEmail(), loginForm.getPassword());
        if(currentUser != null){
            wallBean.setMessages(MessageHandler.getAllMessages(currentUser.getId()));
            return "index";
        }
        return "register";
    }

    public UserBean getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserBean currentUser) {
        this.currentUser = currentUser;
    }

    public WallBean getWallBean() {
        return wallBean;
    }
}
