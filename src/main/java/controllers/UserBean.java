package controllers;

/**
 * Created by johan on 10/11/15.
 */
public class UserBean {

    private String firstName;
    private String lastName;
    private int Id;

    public UserBean(){
    }

    public UserBean(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName(){
        return firstName + " " + lastName;
    }


}
