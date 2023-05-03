package ro.acligalabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.acligalabs.model.User;
import ro.acligalabs.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/users/byParam", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserByParam(@RequestParam Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @PutMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @PatchMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void patchUser(@PathVariable Integer id, @RequestBody Map<String, String> partialUser) {
        userService.patchUser(id, partialUser);
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
