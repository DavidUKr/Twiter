package app.Twiter.controller;

import app.Twiter.model.Post;
import app.Twiter.model.projections.PostDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/feed")
public interface FeedController {

    @Operation(summary = "This endpoint uses path variable user_id and returns a personalized feed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Feed recieved",
                    content = {@Content(mediaType = "application/json",
                            schema =  @Schema(implementation = Post.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",content = @Content),
            @ApiResponse(responseCode = "500", description = "Could not return feed",content = @Content)
    })
    @GetMapping(value = "/user_id",produces = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getMyFeed(@PathVariable Integer user_id);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getAllFeed();

    @Operation(summary = "This endpoint controls user following")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User followed",
                    content = {@Content(mediaType = "application/json")
                    }),
            @ApiResponse(responseCode = "400", description = "Bad request",content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Something happened, could not follow user",content = @Content)
    })
    @PostMapping (value = "/{user_id}/{id_to_follow}/follow")
    void followUser(@PathVariable Integer user_id,@PathVariable Integer id_to_follow);

    @Operation(summary = "This endpoint controls user following")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User unfollowed",
                    content = {@Content(mediaType = "application/json")
                    }),
            @ApiResponse(responseCode = "400", description = "Bad request",content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Something happened, you are forever following this user",content = @Content)
    })
    @PostMapping (value = "/{user_id}/{id}/unfollow", consumes = MediaType.APPLICATION_JSON_VALUE)
    void unfollowUser(@PathVariable Integer user_id,@PathVariable Integer id);

    @PostMapping (value = "/{user_id}/{post_id}/retweet")
    void repost(@PathVariable Integer user_id, @PathVariable Integer post_id);

    @PostMapping(value = "/{user_id}/{post_id}/like")
    void likePost(@PathVariable Integer user_id, @PathVariable Integer post_id);

    @DeleteMapping(value = "/{user_id}/{post_id}/like")
    void unlikePost(@PathVariable Integer user_id, @PathVariable Integer post_id);
}
