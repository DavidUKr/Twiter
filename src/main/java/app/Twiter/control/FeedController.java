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
        return postService.getUserFeed(user_id);
    }
    //TODO implement feed to show latest posts
    @GetMapping(value ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getAllFeed(){
        return postService.getAll();
    }

    @PostMapping (value = "/{id}/follow")
    public void followUser(@PathVariable Integer user_id,@PathVariable Integer id){
        userService.addFollowing(user_id, id);
    }

    @PostMapping (value = "/{id}/unfollow", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void unfollowUser(@PathVariable Integer user_id,@PathVariable Integer id){
        userService.removeFollowing(user_id, id);
    }

    @PostMapping (value = "/{post_id}/retweet")
    public void repost(@PathVariable Integer user_id, @PathVariable Integer post_id){
        postService.repost(user_id, post_id);
    }

    @PostMapping(value = "/{post_id}/like")
    public void likePost(@PathVariable Integer user_id, @PathVariable Integer post_id){
        postService.likePost(user_id, post_id);
    }

    @DeleteMapping(value = "/{post_id}/like")
    public void unlikePost(@PathVariable Integer user_id, @PathVariable Integer post_id){
        postService.unlikePost(user_id, post_id);
    }
}
