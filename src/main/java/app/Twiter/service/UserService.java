package app.Twiter.service;

import app.Twiter.model.Mention;
import app.Twiter.model.User;
import app.Twiter.model.projections.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<UserDTO> registerUser(UserDTO userDTO);
    ResponseEntity.BodyBuilder deleteUser(String id);
    void updateUser(String id, UserDTO userDTO);
    UserDTO getUserDTOByID(String id);
    User getUserByID(String id);
    UserDTO getUserAccount(String id);
    List<UserDTO> getAll();
    List<UserDTO> searchUserByName(String name);
    void addFollowing(String follower, String followed);
    void removeFollowing(String follower, String followed);

    public boolean checkUserExists(String id);

    List<Mention> getUserMentions(String id);
}
