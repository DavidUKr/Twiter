package app.Twiter.controller;

import app.Twiter.model.projections.PostDTO;
import app.Twiter.service.PostService;
import app.Twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FeedControllerImpl implements FeedController{

    @Autowired
    PostService postService;
    UserService userService;

    public List<PostDTO> getMyFeed(@PathVariable String user_id){
        return postService.getUserFeed(user_id);
    }
    //TODO implement feed to show latest posts

    public List<PostDTO> getAllFeed(){
        return postService.getAll();
    }

    public void followUser(@PathVariable String user_id,@PathVariable String id_to_follow){
        userService.addFollowing(user_id, id_to_follow);
    }

    public void unfollowUser(@PathVariable String user_id,@PathVariable String id){
        userService.removeFollowing(user_id, id);
    }

    public void repost(@PathVariable String user_id, @PathVariable String post_id){
        postService.repost(user_id, post_id);
    }

    public void likePost(@PathVariable String user_id, @PathVariable String post_id){
        postService.likePost(user_id, post_id);
    }

    public void unlikePost(@PathVariable String user_id, @PathVariable String post_id){
        postService.unlikePost(user_id, post_id);
    }
}
