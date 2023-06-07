package app.Twiter.controller;

import app.Twiter.model.Post;
import app.Twiter.model.Reply;
import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.ReplyDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1/posts/")
public interface PostController {

    //CREATE
    @Operation(summary = "This endpoint adds post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post added",
                    content = { @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json",
                            schema = @Schema(implementation = Post.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request",content = @io.swagger.v3.oas.annotations.media.Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @io.swagger.v3.oas.annotations.media.Content),
            @ApiResponse(responseCode = "500", description = "Something happened, could not add post",content = @io.swagger.v3.oas.annotations.media.Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void addPostToUser(@PathVariable String user_id, @RequestBody PostDTO postDTO);

    @PostMapping (value = "/feed/{post_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void replyPost(@PathVariable String user_id, @PathVariable String post_id, @RequestBody PostDTO postDTO, @RequestParam boolean isPublic);

    //READ
    @GetMapping(value="/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getMyPosts(@PathVariable String user_id);

    @GetMapping(value = "/{user_id}/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getMyPostsNewerThan(@PathVariable String user_id, @RequestParam String oldest_date);

    @GetMapping(value = "/{post_id}/replies", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ReplyDTO> getMyPostReplies(@PathVariable String post_id);

    //DELETE
    @DeleteMapping( value = "/{post_id}")
    void deletePost(@RequestParam String post_id);
}
