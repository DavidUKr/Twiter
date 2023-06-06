package app.Twiter.controller;

import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.ReplyDTO;
import app.Twiter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public class PostControllerImpl implements PostController{
    @Autowired
    PostService postService;

    //CREATE
    public void addPostToUser(@PathVariable String user_id, @RequestBody PostDTO postDTO){
        postService.createPost(postDTO, user_id);
    }

    public void replyPost(@PathVariable String user_id, @PathVariable String post_id, @RequestBody String text, @RequestBody String url, @RequestParam boolean isPublic){
        postService.createReply(user_id, post_id, text, url, isPublic);
    }

    //READ
    public List<PostDTO> getMyPosts(@PathVariable String user_id){
        return postService.getPostsFromUser(user_id);
    }

    public List<PostDTO> getMyPostsNewerThan(@PathVariable String user_id, @RequestParam String oldest_date){
        return postService.getPostsFromUserNewerThan(user_id, oldest_date);
    }

    public List<ReplyDTO> getMyPostReplies(@PathVariable String post_id){
        return postService.getMyPostReplies(post_id);
    }

    //DELETE
    public void deletePost(@RequestParam String post_id){
        postService.deletePost(post_id);
    }
}
