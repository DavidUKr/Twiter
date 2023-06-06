package app.Twiter.controller;

import app.Twiter.model.projections.UserDTO;
import app.Twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserControllerImpl implements UserController{

    @Autowired
    private UserService userService;
    //CREATE
    public void registerUser(@RequestBody UserDTO userDTO){
        userService.registerUser(userDTO);
    }

    //READ
    public List<UserDTO> getAllUsers(){
        return userService.getAll();
    }

    public UserDTO getUserById(@PathVariable Integer id){
        return userService.getUserByID(id);
    }

    public List<UserDTO> searchUserByName(@RequestParam String name){
        return userService.searchUserByName(name);
    }

    //UPDATE
    public void patchUser(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        userService.updateUser(id, userDTO);
    }

    //DELETE
    public void unregisterUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    //TODO implement get Mentions
}
