package app.Twiter.controller;

import app.Twiter.model.Mention;
import app.Twiter.model.projections.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/users")
public interface UserController {
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO); //returns user id

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> getAllUsers();

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getUserById(@PathVariable String id);

    @GetMapping(value = "/{id}/myaccount", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getMyAccount(@PathVariable String id);

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> searchUserByName(@RequestParam String name);

    @GetMapping(value= "{id}/mentions", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Mention> getUserMentions(@PathVariable String id);

    @PatchMapping(value = "/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
    void patchUser(@PathVariable String id, @RequestBody UserDTO userDTO);

    @DeleteMapping(value = "/{id}")
    ResponseEntity.BodyBuilder unregisterUser(@PathVariable String id);

}
