package app.Twiter.service;

import app.Twiter.advice.exception.DatabaseErrorException;
import app.Twiter.advice.exception.InvalidDataException;
import app.Twiter.advice.exception.UserNotFoundException;
import app.Twiter.model.Follow;
import app.Twiter.model.Mention;
import app.Twiter.model.User;
import app.Twiter.model.projections.UserDTO;
import app.Twiter.repository.FollowRepo;
import app.Twiter.repository.LikeRepo;
import app.Twiter.repository.MentionRepo;
import app.Twiter.repository.UserRepo;
import app.Twiter.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final FollowRepo followRepo;
    private final LikeRepo likeRepo;
    private final MentionRepo mentionRepo;
    private final UserUtil userUtil;

    @Override
    public ResponseEntity<UserDTO> registerUser(UserDTO userDTO) {
         if(checkUserCreationIntegrity(userDTO)){
             userRepo.save(userUtil.patchUserFromDTO(userDTO));
         }
        //return ResponseEntity.status(HttpStatus.CREATED).body("{\"id\":\""+userRepo.findByUsername(userDTO.getUserName()).getId()+"\"}");
        return ResponseEntity.status(HttpStatus.CREATED).body(userUtil.patchUserDTO(userRepo.findByUsername(userDTO.getUserName())));
    }

    @Override
    public ResponseEntity.BodyBuilder deleteUser(String id) { //also deletes user posts follows and likes
        if(checkUserExists(id)) {
            User user=userRepo.findById(id).get();
            followRepo.deleteAllByFollower(user);
            //postService.deletePostsFromUser(id);
            likeRepo.deleteAllByOwnerId(user);
            userRepo.delete(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

    @Override
    public void updateUser(String id, UserDTO userDTO) {
        if(checkUserExists(id)) {
            User aux=userRepo.findById(id).get();
            User user = userUtil.patchUserFromDTO(userDTO);
            user.setId(id);
            user.setPassword(aux.getPassword());
            userRepo.save(user);
        }
    }

    @Override
    public UserDTO getUserDTOByID(String id) throws UserNotFoundException{
        if (checkUserExists(id))
            return userUtil.patchUserDTO(userRepo.findById(id).get());
        else return null;
    }

    @Override
    public User getUserByID(String id) {
        if(checkUserExists(id)) {
            if(userRepo.findById(id).isEmpty()) throw new DatabaseErrorException("Data not recieved");
            return userRepo.findById(id).get();
        }
        else return null;
    }

    @Override
    public UserDTO getUserAccount(String id) {
        if (checkUserExists(id))
            return userUtil.patchUserDTOwPassword(userRepo.findById(id).get());
        else return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepo.findAll()
                .stream()
                .map(user -> userUtil.patchUserDTO(user))
                .toList();
    }

    @Override
    public List<UserDTO> searchUserByName(String name) {
        List<UserDTO> results=userRepo.searchByUsernameOrFirstNameOrLastName(name)
                .stream()
                .map(user -> userUtil.patchUserDTO(user))
                .toList();
        if(results.isEmpty()) throw new UserNotFoundException("No matching user found");
        else return results;
    }

    @Override
    public void addFollowing(String followerId, String followedId) {
        if(checkUserExists(followerId)&&checkUserExists(followedId)) {
            User follower=userRepo.findById(followerId).get();
            User followed=userRepo.findById(followedId).get();
            Follow follow = new Follow(follower, followed);
            followRepo.save(follow);
            follower.addFollow();
            followed.addFollower();
            updateUser(followerId, userUtil.patchUserDTO(follower));
            updateUser(followedId, userUtil.patchUserDTO(followed));
        }
    }

    @Override
    public void removeFollowing(String followerId, String followedId) {
        if(checkUserExists(followerId)&&checkUserExists(followedId)) {
            User follower = userRepo.findById(followerId).get();
            User followed = userRepo.findById(followedId).get();
            followRepo.deleteByFollowerAndFollowed(follower, followed);
            follower.addFollow();
            followed.addFollower();
            updateUser(followerId, userUtil.patchUserDTO(follower));
            updateUser(followedId, userUtil.patchUserDTO(followed));
        }
    }

    public boolean checkUserExists(String id) throws UserNotFoundException{
        if(userRepo.existsById(id)) return true;
        else throw new UserNotFoundException("User with id:"+id+" not found");
    }

    @Override
    public List<Mention> getUserMentions(String id) {
        if(checkUserExists(id)){
            return mentionRepo.findAllByMentioned(userRepo.findById(id).get());
        }
        else return null;
    }

    private boolean checkUserCreationIntegrity(UserDTO userDTO)throws  InvalidDataException{
        if(userDTO.getUserName()==null) throw new InvalidDataException("userName is null");
        else if(userDTO.getFirstName()==null) throw new InvalidDataException("firstName is null");
        else if(userDTO.getLastName()==null) throw new InvalidDataException("lastName is null");
        else if(userDTO.getEmail()==null) throw new InvalidDataException("email is null");
        else if(userDTO.getPassword()==null) throw new InvalidDataException("password is null");
        else return true;
    }
}
