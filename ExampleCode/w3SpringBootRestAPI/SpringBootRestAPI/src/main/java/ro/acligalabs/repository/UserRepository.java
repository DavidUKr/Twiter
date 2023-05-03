package ro.acligalabs.repository;

import org.springframework.stereotype.Repository;
import ro.acligalabs.advice.exception.UserNotFoundException;
import ro.acligalabs.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private Map<Integer, User> USERS = new HashMap<>();
    private Integer index = 0;

    public List<User> getAllUsers() {
        return USERS.values().stream().collect(Collectors.toList());
    }

    public void createUser(User user) {
        user.setId(index);
        USERS.put(index, user);
        index++;
    }

    public void updateUser(Integer id, User user) {
        getUserById(id);
        user.setId(id);
        USERS.put(id, user);
    }

    public void deleteUser(int id) {
        USERS.remove(id);
    }

    public User getUserById(Integer id) {
        User user = USERS.get(id);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException(String.format("User with id %s was not found", id));
        }
        return user;
    }
}
