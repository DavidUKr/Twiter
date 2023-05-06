package app.Twiter.control;

import app.Twiter.model.Post;
import app.Twiter.service.PostService;
import app.Twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/users/{user_id}")
public class PostController {

    //TODO add @RequestMapping to controllers
    @Autowired
    PostService postService;
    UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPostToUser(@RequestParam Integer user_id, @RequestBody Post post){
        postService.createPost(post, user_id);
    }

    @GetMapping(value="/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getMyPosts(@PathVariable Integer user_id){
        return userService.getPostsFromUser(user_id);
    }
}
