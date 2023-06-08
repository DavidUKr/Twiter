package app.Twiter.util;

import app.Twiter.model.User;
import app.Twiter.model.projections.UserDTO;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserUtil {
    public void patchUser(User user, Map<String, String> partialUser){
        String firstName = partialUser.get("firstName");
        String lastName = partialUser.get("lastName");
        String email = partialUser.get("email");
        String password = partialUser.get("password");
        if (firstName != null) {
            user.setFirstName(firstName);
        }
        if (lastName != null) {
            user.setLastName(lastName);
        }
        if (email != null) {
            user.setEmail(email);
        }
        if (password != null) {
            user.setPassword(password);
        }
    }

    public User patchUserFromDTO(UserDTO userDTO){
        return new User(userDTO.getUserName(), userDTO.getLastName(), userDTO.getFirstName(), userDTO.getEmail());
    }

    public UserDTO patchUserDTO(User user){
        return new UserDTO(user.getUsername(), user.getLastName(), user.getFirstName(),user.getEmail(), user.getFollowerCount(), user.getFollowCount());
    }
}
