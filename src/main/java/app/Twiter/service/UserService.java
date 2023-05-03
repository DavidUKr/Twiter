package app.Twiter.service;

import app.Twiter.model.User;
import app.Twiter.repository.UserRepo;
import app.Twiter.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService{

    UserRepo userRepo;
    UserUtil userUtil;
    @Autowired
    public UserService(UserRepo userRepo, UserUtil userUtil){
        this.userRepo=userRepo;
        this.userUtil=userUtil;
    }

    @Override
    public void registerUser(User user) {
        userRepo.createUser(user);
    }

    @Override
    public void deleteUser(Integer ID) {
        userRepo.deleteUser(ID);
    }

    @Override
    public void patchUser(User user, Map<String, String> partialUser) {
        userUtil.pathUser(user, partialUser);
    }

    @Override
    public void updateUser(Integer ID, String new_username) {
        userRepo.updateUser(ID, new_username);
    }

    @Override
    public User getByID(Integer ID) {
        return userRepo.getUserByID(ID);
    }

    @Override
    public List<User> getAll() {

        return userRepo.getAllUsers();
    }
}
