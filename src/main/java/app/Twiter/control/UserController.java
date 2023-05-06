package app.Twiter.control;

import app.Twiter.model.User;
import app.Twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/users")
public class UserController {

    //CREATE
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
    }

    //READ
    @Autowired
    private UserService userService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable Integer id){
        return userService.getByID(id);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> searchUserByName(@RequestParam String name){
        return userService.searchByName(name);
    }

    //UPDATE
    @PatchMapping(value = "/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public void patchUser(@RequestParam Integer id, @RequestBody User user){
        userService.updateUser(id, user);
    }

    //DELETE
}