package app.Twiter.service;

import app.Twiter.model.projections.UserDTO;
import java.util.List;
import java.util.Map;

public interface UserService {
    void registerUser(UserDTO userDTO);
    void deleteUser(Integer ID);
    void patchUser(Integer ID, Map<String, String> partialUser);
    void updateUser(Integer ID, UserDTO userDTO);
    UserDTO getUserByID(Integer ID);
    List<UserDTO> getAll();
    List<UserDTO> searchUserByName(String name);
    void addFollowing(Integer follower, Integer followed);
    void removeFollowing(Integer follower, Integer followed);
}
