package app.Twiter.util;

import app.Twiter.model.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserUtil {
    public void pathUser(User user, Map<String, String> partialUser){
        String firstName = partialUser.get("firstName");
        String lastName = partialUser.get("lastName");
        String email = partialUser.get("email");
        String password = partialUser.get("password");
        if (firstName != null) {
            user.setFIRST_NAME(firstName);
        }
        if (lastName != null) {
            user.setLAST_NAME(lastName);
        }
        if (email != null) {
            user.setEMAIL(email);
        }
        if (password != null) {
            user.setPASSWORD(password);
        }
    }
}
