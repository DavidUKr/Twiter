package app.Twiter.controllers.post;

import app.Twiter.model.Post;
import app.Twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetOwnPostsController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/{id}/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getMyPosts(@RequestParam Integer id){
        return userService.getPostsFromUser(id);
    }
}
