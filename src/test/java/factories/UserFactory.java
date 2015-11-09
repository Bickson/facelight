package factories;

import models.User;

/**
 * Created by dario on 2015-11-06.
 */
public class UserFactory {

    public static User createUser(String... args){
        String email = "test@email.com";
        String password = "123";
        String name = "test";
        for(int i=0; i<args.length; i++){
            switch (i){
                case 0:
                    email = args[i];
                    break;
                case 1:
                    name = args[i];
                    break;
                case 2:
                    password = args[i];
                    break;
            }
        }
        User user = new User();
        user.setFirstName(name);
        user.setLastName("florez");
        user.setEmail(email);
        user.setNickname("nicktest");
        user.setPassword(password);
        user.setPasswordConfirmation(password);
        return user;
    }
}
