package app.Twiter.repository;

import app.Twiter.model.Post;
import app.Twiter.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UserRepo {
    Map <Integer, User> USERS=new HashMap<>();

    private Integer index=0;

    public List<User> getAllUsers(){
        return USERS.values().stream().collect(Collectors.toList());
    }

    //create,delete,search,update,getPosts

    public void createUser(User user){
        user.setID(index);
        USERS.put(index, user);
        index++;
    }

    public void deleteUser(int ID){
        USERS.remove(ID);
    }

    public User getUserByID(int ID){
        User user=USERS.get(ID);
        if(Objects.isNull(user)) throw new RuntimeException("UserNotFound ID:"+ID); //subject to change
        return user;
    }

    public void updateUser(int ID, String new_username){
        User user=getUserByID(ID);
        user.setUSERNAME(new_username);
    } //to be overloaded

    public List<Post> getUserPosts(Integer ID){
        User user=getUserByID(ID);
        return user.getAllPosts();
    }
}
