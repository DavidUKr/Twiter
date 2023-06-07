package app.Twiter.service;

import app.Twiter.advice.exception.UserNotFoundException;
import app.Twiter.model.Follow;
import app.Twiter.model.User;
import app.Twiter.model.projections.UserDTO;
import app.Twiter.repository.FollowRepo;
import app.Twiter.repository.LikeRepo;
import app.Twiter.repository.UserRepo;
import app.Twiter.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;
    FollowRepo followRepo;
    LikeRepo likeRepo;
    PostService postService;
    UserUtil userUtil;

    @Override
    public void registerUser(UserDTO userDTO) {
        userRepo.save(userUtil.patchUserFromDTO(userDTO));
    }

    @Override
    public void deleteUser(String id) { //also deletes user posts follows and likes
        if(checkUserExists(id)) {
            User user=userRepo.findById(id).get();
            followRepo.deleteAllByFollower(user);
            postService.deletePostsFromUser(id);
            likeRepo.deleteAllByOwnerId(user);
            userRepo.delete(user);
        }
    }

    @Override
    public void updateUser(String id, UserDTO userDTO) {
        User user=userUtil.patchUserFromDTO(userDTO);
        user.setId(id);
        userRepo.save(user); //if exists updates, else inserts
    }

    @Override
    public UserDTO getUserDTOByID(String id) throws UserNotFoundException{
        if (checkUserExists(id))
            return userUtil.patchUserDTO(userRepo.findById(id).get());
        else return null;
    }

    @Override
    public User getUserByID(String id) {
        if(checkUserExists(id)) return userRepo.findById(id).get();
        else return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepo.findAll()
                .stream()
                .map(user -> userUtil.patchUserDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> searchUserByName(String name) {
        return userRepo.findAllByUsernameRegexOrFirstNameRegexOrLastNameRegex(name)
                .stream()
                .map(user -> userUtil.patchUserDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public void addFollowing(String follower, String followed) {
        if(checkUserExists(follower)&&checkUserExists(followed)) {
            Follow follow = new Follow(userRepo.findById(follower).get(), userRepo.findById(followed).get());
            followRepo.save(follow);
        }
    }

    @Override
    public void removeFollowing(String follower, String followed) {
        if(checkUserExists(follower)&&checkUserExists(followed)){
            followRepo.deleteByFollowerAndFollowed(userRepo.findById(follower).get(), userRepo.findById(followed).get());
        }
    }

    private boolean checkUserExists(String id) throws UserNotFoundException{
        if(userRepo.existsById(id)) return true;
        else throw new UserNotFoundException("User with id:"+id+" not found");
    }

}
