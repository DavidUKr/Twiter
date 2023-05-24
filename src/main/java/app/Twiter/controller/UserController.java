package app.Twiter.controller;

import app.Twiter.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/users")
public interface UserController {

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void registerUser(@RequestBody User user);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> getAllUsers();

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    User getUserById(@PathVariable Integer id);

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> searchUserByName(@RequestParam String name);

    @PatchMapping(value = "/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
    void patchUser(@PathVariable Integer id, @RequestBody User user);

    @DeleteMapping(value = "/{id}")
    void unregisterUser(@PathVariable Integer id);
}
