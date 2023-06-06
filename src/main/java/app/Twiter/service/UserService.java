package app.Twiter.service;

import app.Twiter.model.projections.UserDTO;
import java.util.List;
import java.util.Map;

public interface UserService {
    void registerUser(UserDTO userDTO);
    void deleteUser(String id);
    void updateUser(String id, UserDTO userDTO);
    UserDTO getUserByID(String id);
    List<UserDTO> getAll();
    List<UserDTO> searchUserByName(String name);
    void addFollowing(String follower, String followed);
    void removeFollowing(String follower, String followed);
}
