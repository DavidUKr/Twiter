package app.Twiter.repository;

import app.Twiter.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UserRepoImpl {
    Map <Integer, User> USERS=new HashMap<>();

    private Integer index=0; //TODO  Upgrade indexing

    public List<User> getAllUsers(){
        return USERS.values().stream().collect(Collectors.toList());
    }

    //CREATE
    public void createUser(User user){
        user.setID(index);
        USERS.put(index, user);
        index++;
    }

    //READ
    public User getUserByID(int ID){
        User user=USERS.get(ID);
        if(Objects.isNull(user)) throw new RuntimeException("UserNotFound ID:"+ID); //subject to change
        return user;
    }

    public List<Integer> getUserPosts(Integer ID){
        User user=getUserByID(ID);
        return user.getAllPosts();
    }

    //UPDATE
    public void updateUser(int ID, User user){
        user.setID(ID);
        USERS.put(ID, user);
    }

    //DELETE
    public void deleteUser(int ID){
        USERS.remove(ID);
    }
}
