package ro.acligalabs.service;

import ro.acligalabs.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Integer id);

    void registerUser(User user);

    void updateUser(Integer id, User user);

    void patchUser(Integer id, Map<String, String> partialUser);

    void deleteUser(Integer id);
}
