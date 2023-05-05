package app.Twiter.controllers;

import app.Twiter.model.Post;
import app.Twiter.service.PostService;
import app.Twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    //TODO Merge into Feed controller and Post Controller
    //TODO add @RequestMapping to controllers
    @Autowired
    PostService postService;
    UserService userService;

    @PostMapping(value = "/{user_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPostToUser(@RequestParam Integer user_id, @RequestBody Post post){
        postService.createPost(post, user_id);
    }

    @GetMapping(value="/{id}/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getMyPosts(@RequestParam Integer id){
        return userService.getPostsFromUser(id);
    }
}
