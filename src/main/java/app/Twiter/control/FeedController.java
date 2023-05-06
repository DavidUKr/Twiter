package app.Twiter.control;

import app.Twiter.model.Post;
import app.Twiter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/users/{user_id}/feed")
public class FeedController {
    @Autowired
    PostService postService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getFeed(){
        return postService.getAll();
    }

    //TODO implement get from personalised feed
}
