package factories;

import models.Message;
import models.MessageType;
import models.User;

import java.util.Date;

/**
 * Created by dario on 2015-11-06.
 */
public class MessageFactory {
    public static Message createMessageWithout(String arg){

       Message message = createMessage();

       switch (arg){
           case "subject":
               message.setSubject(null);
               break;
           case "content":
               message.setContent(null);
               break;
           case "type":
               message.setType(null);
               break;
       }
       return message;
    }
    public static  Message createMessage(){
        Message message = new Message();
        message.setType(MessageType.PRIVATE);
        message.setCreatedAt(new Date());
        message.setContent("Test");
        return message;
    }
}
