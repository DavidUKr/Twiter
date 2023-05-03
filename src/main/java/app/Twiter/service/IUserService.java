package app.Twiter.service;

import app.Twiter.model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    void registerUser(User user);
    void deleteUser(Integer ID);
    void patchUser(User user, Map<String, String> partialUser);
    void updateUser(Integer ID, String new_username);
    User getByID(Integer ID);
    List<User> getAll();
}
