package app.Twiter.controller;

import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.ReplyDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/posts/")
public interface PostController {
    //CREATE
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity.BodyBuilder addPostToUser(@PathVariable String user_id, @RequestBody PostDTO postDTO);

    //READ
    @GetMapping(value="/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getMyPosts(@PathVariable String user_id);

    @GetMapping(value = "/{user_id}/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getMyPostsNewerThan(@PathVariable String user_id, @RequestParam String oldestDate);

    @GetMapping(value = "/{post_id}/my_replies", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ReplyDTO> getMyPostReplies(@PathVariable String post_id);

    @GetMapping(value = "/{post_id}/replies", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ReplyDTO> getPostReplies(@PathVariable String post_id);

    //DELETE
    @DeleteMapping( value = "/{post_id}")
    ResponseEntity.BodyBuilder deletePost(@RequestParam String post_id);
}
