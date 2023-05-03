package app.Twiter.controllers.post;

import app.Twiter.model.Post;
import app.Twiter.service.PostService;
import app.Twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddPostController {
    @Autowired
    PostService postService;

    @PostMapping(value = "/{user_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPostToUser(@RequestParam Integer user_id, @RequestBody Post post){
        postService.createPost(post, user_id);
    }
}
