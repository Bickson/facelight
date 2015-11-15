package controllers;

import handlers.UserHandler;
import models.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by johan on 10/11/15.
 */
@ManagedBean(name="search")
@RequestScoped
public class SearchController {

    private String query;
    private ArrayList<String> users = new ArrayList<String>();

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String search(){
        Collection<User> col = UserHandler.getUserByName(query);
        col.forEach(item -> System.out.println(item.getFirstName()));

        if(col != null) {
            col.forEach(user -> users.add(user.getFirstName() + " " + user.getLastName()));
        }
        return "search";
    }


}