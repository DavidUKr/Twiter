package app.Twiter.service;

import app.Twiter.model.Post;
import app.Twiter.model.User;
import app.Twiter.repository.UserRepoImpl;
import app.Twiter.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    UserRepoImpl userRepo;
    UserUtil userUtil;
    PostService postService;
    @Autowired
    public UserServiceImpl(UserRepoImpl userRepo, UserUtil userUtil, PostService postService){
        this.userRepo=userRepo;
        this.userUtil=userUtil;
        this.postService=postService;
    }

    @Override
    public void registerUser(User user) {
        userRepo.createUser(user);
    }

    @Override
    public void deleteUser(Integer ID) {
        for(Post post: postService.getPostsFromUser(ID)){ //delete posts from PostRepoImpl
            postService.deletePost(post.getID());
        }
        postService.getPostsFromUser(ID).clear(); //delete posts from user data
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
    public User getUserByID(Integer ID) {
        return userRepo.getUserByID(ID);
    }

    @Override
    public List<User> getAll() {

        return userRepo.getAllUsers();
    }

    @Override
    public List<User> searchUserByName(String name) {
        return userRepo.getAllUsers().stream()
                .filter(user -> user.getUSERNAME().contains(name) ||
                        user.getFIRST_NAME().contains(name) ||
                        user.getLAST_NAME().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public void addFollowing(Integer follower, Integer followed) {
        userRepo.getUserByID(follower).addFollowing(followed);
        userRepo.getUserByID(followed).addFollower(follower);
    }

    @Override
    public void removeFollowing(Integer follower, Integer followed) {
        userRepo.getUserByID(follower).removeFollowing(followed);
        userRepo.getUserByID(followed).removeFollower(follower);
    }

}
