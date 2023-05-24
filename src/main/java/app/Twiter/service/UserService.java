package app.Twiter.service;

import app.Twiter.model.Post;
import app.Twiter.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    void registerUser(User user);
    void deleteUser(Integer ID);
    void patchUser(Integer ID, Map<String, String> partialUser);
    void updateUser(Integer ID, User user);
    User getUserByID(Integer ID);
    List<User> getAll();
    List<User> searchUserByName(String name);
    void addFollowing(Integer follower, Integer followed);
    void removeFollowing(Integer follower, Integer followed);
}
