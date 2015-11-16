package handlers;

import ViewModels.UserViewModel;
import dao.UserDAO;
import forms.UserForm;
import models.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dario on 2015-11-09.
 */
public class UserHandler {

    private static UserDAO userDAO = new UserDAO();

    public static UserViewModel authenticateUser(String email, String password){
        if(email.equals(null) || password.equals(null)){
            return null;
        }
        UserViewModel userViewModel = new UserViewModel();
        User user = userDAO.authenticateUser(email,password);
        if(user != null){
            //create userBean
            userViewModel.setId(user.getId());
            userViewModel.setFirstName(user.getFirstName());
            userViewModel.setLastName(user.getLastName());

        }
        return userViewModel;
    }

    public static User createUser(UserForm userForm){

        User user = new User();
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPasswordConfirmation(userForm.getPasswordConfirmation());

        return userDAO.create(user);
    }

    //Return ArrayList<UseViewModel>
    public static ArrayList<UserViewModel>getUserByName(String query){
        //Fix here
        Collection<User> users = userDAO.listUserByName(query);
        ArrayList<UserViewModel> usersModelView = new ArrayList<>();
        users.forEach(m -> usersModelView.add(
                new UserViewModel(m.getId(), m.getFirstName(), m.getLastName())));

        return usersModelView;
    }

    public static Collection getAllUsers(){
        Collection<User> users = userDAO.listUsers();
        return users;
    }


}
