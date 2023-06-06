package app.Twiter.service;

import app.Twiter.model.projections.UserDTO;
import app.Twiter.repository.UserRepo;
import app.Twiter.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;
    PostService postService;
    UserUtil userUtil;

    @Override
    public void registerUser(UserDTO userDTO) {
    }

    @Override
    public void deleteUser(Integer ID) {

    }

    @Override
    public void patchUser(Integer ID, Map<String, String> partialUser) {

    }

    @Override
    public void updateUser(Integer ID, UserDTO userDTO) {

    }

    @Override
    public UserDTO getUserByID(Integer ID) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public List<UserDTO> searchUserByName(String name) {
        return null;
    }

    @Override
    public void addFollowing(Integer follower, Integer followed) {

    }

    @Override
    public void removeFollowing(Integer follower, Integer followed) {

    }
}
