package app.Twiter.controller;

import app.Twiter.model.Post;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/posts/")
public interface PostController {
    void addPostToUser(@PathVariable Integer user_id, @RequestBody Post post);
}
