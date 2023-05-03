package ro.acligalabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.acligalabs.model.User;
import ro.acligalabs.repository.UserRepository;
import ro.acligalabs.util.UserUtil;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserUtil userUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserUtil userUtil) {
        this.userRepository = userRepository;
        this.userUtil = userUtil;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    public void registerUser(User user) {
        userRepository.createUser(user);
    }

    public void updateUser(Integer id, User user) {
        userRepository.updateUser(id, user);
    }

    public void patchUser(Integer id, Map<String, String> partialUser) {
        User user = userRepository.getUserById(id);

        userUtil.patchUser(user, partialUser);

        userRepository.updateUser(id, user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteUser(id);
    }
}
