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
    @Autowired
    PostService postService;
    UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPostToUser(@PathVariable Integer user_id, @RequestBody Post post){
        postService.createPost(post, user_id);
    }

    @GetMapping(value="/myposts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getMyPosts(@PathVariable Integer user_id){
        return userService.getPostsFromUser(user_id);
    }
    @GetMapping(value = "/myposts/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getMyNewerThan(@PathVariable Integer user_id, @RequestParam Integer oldest_date){
        return userService.getPostsFromUserNewerThan(user_id, oldest_date);
    }
}
