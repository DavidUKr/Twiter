package app.Twiter.control;

import app.Twiter.model.Post;
import app.Twiter.model.User;
import app.Twiter.service.PostService;
import app.Twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/users/{user_id}/feed")
public class FeedController {
    @Autowired
    PostService postService;
    UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getMyFeed(@PathVariable Integer user_id){
        return userService.getUserFeed(user_id);
    }

    @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getAllFeed(){
        return postService.getAll();
    }

    //TODO implement get from personalised feed
    @PostMapping (value = "/{id}")
    public void followUser(@PathVariable Integer user_id,@PathVariable Integer id){
        userService.addFollowing(user_id, id);
    }

    @PostMapping (value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void unfollowUser(@PathVariable Integer user_id,@PathVariable Integer id){
        userService.removeFollowing(user_id, id);
    }
}