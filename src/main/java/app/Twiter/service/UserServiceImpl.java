package app.Twiter.service;

import app.Twiter.advice.exception.UserNotFoundException;
import app.Twiter.model.User;
import app.Twiter.model.projections.UserDTO;
import app.Twiter.repository.UserRepo;
import app.Twiter.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public void updateUser(String id, UserDTO userDTO) {
        User user=userUtil.patchUserFromDTO(userDTO);
        user.setId(id);
        userRepo.save(user); //if exists updates, else inserts
    }

    @Override
    public UserDTO getUserByID(String id) throws UserNotFoundException{
        if (userRepo.existsById(id)){
            return userUtil.patchUserDTO(userRepo.findById(id).get());
        }
        else throw new UserNotFoundException("User not found");
    }

    @Override
    public List<UserDTO> getAll() {
        ArrayList<User> users=(ArrayList<User>) userRepo.findAll();
        ArrayList<UserDTO> userDTOS=new ArrayList<>();
        return users.stream().map(user -> userUtil.patchUserDTO(user)).collect(Collectors.toList());
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
