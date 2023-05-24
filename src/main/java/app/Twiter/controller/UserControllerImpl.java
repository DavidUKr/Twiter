package app.Twiter.controller;

import app.Twiter.model.User;
import app.Twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserControllerImpl implements UserController{

    @Autowired
    private UserService userService;
    //CREATE
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
    }

    //READ
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    public User getUserById(@PathVariable Integer id){
        return userService.getUserByID(id);
    }

    public List<User> searchUserByName(@RequestParam String name){
        return userService.searchUserByName(name);
    }

    //UPDATE
    public void patchUser(@PathVariable Integer id, @RequestBody User user){
        userService.updateUser(id, user);
    }

    //DELETE
    public void unregisterUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    //TODO implement get mentions QUESTION: Implemented by Frontend or Backend?
}
