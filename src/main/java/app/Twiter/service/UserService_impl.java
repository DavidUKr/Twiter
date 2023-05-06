package app.Twiter.service;

import app.Twiter.model.Post;
import app.Twiter.model.User;
import app.Twiter.repository.UserRepo;
import app.Twiter.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService_impl implements UserService{

    UserRepo userRepo;

    UserUtil userUtil;
    @Autowired
    public UserService_impl(UserRepo userRepo, UserUtil userUtil){
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
    public void patchUser(Integer ID, Map<String, String> partialUser) {
        User toUpdate=userRepo.getUserByID(ID);
        userUtil.patchUser(toUpdate, partialUser);
        updateUser(ID, toUpdate);
    }

    @Override
    public void updateUser(Integer ID, User user) {
        userRepo.updateUser(ID, user);
    }

    @Override
    public User getByID(Integer ID) {
        return userRepo.getUserByID(ID);
    }

    @Override
    public List<User> getAll() {

        return userRepo.getAllUsers();
    }

    @Override
    public List<User> searchByName(String name) {
        return userRepo.getAllUsers().stream()
                .filter(user -> user.getUSERNAME().contains(name) ||
                        user.getFIRST_NAME().contains(name) ||
                        user.getLAST_NAME().contains(name))
                .collect(Collectors.toList());
    }

    public List<Post> getPostsFromUser(Integer ID){
        return userRepo.getUserPosts(ID);
    }
}
