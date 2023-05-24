package app.Twiter.controller;

import app.Twiter.model.Post;
import app.Twiter.model.Posting;
import app.Twiter.service.PostService;
import app.Twiter.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FeedControllerImpl implements FeedController{

    @Autowired
    PostService postService;
    UserService userService;

    public List<Post> getMyFeed(@PathVariable Integer user_id){
        return postService.getUserFeed(user_id);
    }
    //TODO implement feed to show latest posts

    public List<Post> getAllFeed(){
        return postService.getAll();
    }

    public void followUser(@PathVariable Integer user_id,@PathVariable Integer id_to_follow){
        userService.addFollowing(user_id, id_to_follow);
    }

    public void unfollowUser(@PathVariable Integer user_id,@PathVariable Integer id){
        userService.removeFollowing(user_id, id);
    }

    public void repost(@PathVariable Integer user_id, @PathVariable Integer post_id){
        postService.repost(user_id, post_id);
    }

    public void likePost(@PathVariable Integer user_id, @PathVariable Integer post_id){
        postService.likePost(user_id, post_id);
    }

    public void unlikePost(@PathVariable Integer user_id, @PathVariable Integer post_id){
        postService.unlikePost(user_id, post_id);
    }
}
