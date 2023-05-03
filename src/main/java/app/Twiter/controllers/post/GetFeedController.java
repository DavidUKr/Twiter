package app.Twiter.controllers.post;

import app.Twiter.model.Post;
import app.Twiter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetFeedController {
    @Autowired
    PostService postService;

    @GetMapping(value = "/feed", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getFeed(){
        return postService.getAll();
    }

    //implement get from personalised feed
}
