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
        userRepo.save(userUtil.patchUserFromDTO(userDTO));
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public void patchUser(String id, Map<String, String> partialUser) {

    }

    @Override
    public void updateUser(String id, UserDTO userDTO) {

    }

    @Override
    public UserDTO getUserByID(String id) {
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
    public void addFollowing(String follower, String followed) {

    }

    @Override
    public void removeFollowing(String follower, String followed) {

    }

}
