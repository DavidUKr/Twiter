package app.Twiter.control;

import app.Twiter.model.Content;
import app.Twiter.model.Post;
import app.Twiter.model.Reply;
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

    //CREATE
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPostToUser(@PathVariable Integer user_id, @RequestBody Post post){
        postService.createPost(post, user_id);
    }
    @PostMapping (value = "/feed/{post_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void replyPost(@PathVariable Integer user_id, @PathVariable Integer post_id, @RequestBody Content content, @RequestParam boolean isPublic){
        postService.createReply(user_id, post_id, content, isPublic);
    }

    //READ
    @GetMapping(value="/myposts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getMyPosts(@PathVariable Integer user_id){
        return userService.getPostsFromUser(user_id);
    }
    @GetMapping(value = "/myposts/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getMyPostsNewerThan(@PathVariable Integer user_id, @RequestParam Integer oldest_date){
        return userService.getPostsFromUserNewerThan(user_id, oldest_date);
    }
    @GetMapping(value = "/myposts/{post_id}/replies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reply> getMyPostReplies(@PathVariable Integer post_id){
        return postService.getMyPostReplies(post_id);
    }

    //DELETE
    @DeleteMapping( value = "/myposts")
    public void deletePost(@RequestParam Integer post_id){
        postService.deletePost(post_id);
    }
}
