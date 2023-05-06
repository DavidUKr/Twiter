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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
    }

}
