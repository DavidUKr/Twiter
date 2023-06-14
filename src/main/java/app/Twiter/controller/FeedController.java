package app.Twiter.controller;

import app.Twiter.model.projections.PostDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/feed")
public interface FeedController {
    @GetMapping(value = "/user_id",produces = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getMyFeed(@PathVariable String user_id);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getAllFeed();

    @PostMapping (value = "/{user_id}/{id_to_follow}/follow")
    void followUser(@PathVariable String user_id,@PathVariable String id_to_follow);

    @DeleteMapping (value = "/{user_id}/{id}/unfollow")
    void unfollowUser(@PathVariable String user_id,@PathVariable String id);

    @PostMapping (value = "/{user_id}/{post_id}/retweet")
    void repost(@PathVariable String user_id, @PathVariable String post_id);

    @PostMapping(value = "/{user_id}/{post_id}/like")
    void likePost(@PathVariable String user_id, @PathVariable String post_id);

    @DeleteMapping(value = "/{user_id}/{post_id}/like")
    void unlikePost(@PathVariable String user_id, @PathVariable String post_id);
}
