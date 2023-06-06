package app.Twiter.controller;

import app.Twiter.model.Post;
import app.Twiter.model.Reply;
import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.ReplyDTO;
import app.Twiter.service.PostService;
import app.Twiter.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;

public class PostControllerImpl implements PostController{
    @Autowired
    PostService postService;

    //CREATE
    public void addPostToUser(@PathVariable Integer user_id, @RequestBody PostDTO postDTO){
        postService.createPost(postDTO, user_id);
    }

    public void replyPost(@PathVariable Integer user_id, @PathVariable Integer post_id, @RequestBody String text, @RequestBody String url, @RequestParam boolean isPublic){
        postService.createReply(user_id, post_id, text, url, isPublic);
    }

    //READ
    public List<PostDTO> getMyPosts(@PathVariable Integer user_id){
        return postService.getPostsFromUser(user_id);
    }

    public List<PostDTO> getMyPostsNewerThan(@PathVariable Integer user_id, @RequestParam String oldest_date){
        return postService.getPostsFromUserNewerThan(user_id, oldest_date);
    }

    public List<ReplyDTO> getMyPostReplies(@PathVariable Integer post_id){
        return postService.getMyPostReplies(post_id);
    }

    //DELETE
    public void deletePost(@RequestParam Integer post_id){
        postService.deletePost(post_id);
    }
}
