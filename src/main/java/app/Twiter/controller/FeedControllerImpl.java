package app.Twiter.controller;

import app.Twiter.model.Post;
import app.Twiter.model.projections.PostDTO;
import app.Twiter.service.PostService;
import app.Twiter.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/feed")
public class FeedControllerImpl implements FeedController{

    @Autowired
    PostService postService;
    UserService userService;

    @Operation(summary = "This endpoint uses path variable user_id and returns a personalized feed (List<PostDTO>).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Feed recieved",
                    content = {@Content(mediaType = "application/json",
                            schema =  @Schema(implementation = Post.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request",content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Could not return feed",content = @Content)
    })
    @GetMapping(value = "/user_id",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PostDTO> getMyFeed(@PathVariable String user_id){
        return postService.getUserFeed(user_id);
    }
    //TODO implement feed to show latest posts

    @Operation(summary = "This endpoint returns a feed containing all posts (List<PostDTO>).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Feed recieved",
                    content = {@Content(mediaType = "application/json",
                            schema =  @Schema(implementation = PostDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Could not return feed")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PostDTO> getAllFeed(){
        return postService.getAll();
    }

    @Operation(summary = "This endpoint controls user following - adds follow entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User followed"),
            @ApiResponse(responseCode = "400", description = "Bad request",content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Something happened, could not follow user",content = @Content)
    })
    @PostMapping (value = "/{user_id}/{id_to_follow}/follow")
    public void followUser(@PathVariable String user_id,@PathVariable String id_to_follow){
        userService.addFollowing(user_id, id_to_follow);
    }

    @Operation(summary = "This endpoint controls user following - deletes follow entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User unfollowed"),
            @ApiResponse(responseCode = "400", description = "Bad request",content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Something happened, you are forever following this user",content = @Content)
    })
    @DeleteMapping (value = "/{user_id}/{id}/unfollow")
    public void unfollowUser(@PathVariable String user_id,@PathVariable String id){
        userService.removeFollowing(user_id, id);
    }

    @Operation(summary = "This endpoint creates a repost - post but with different author than owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Repost created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Something happened, could not add repost")
    })
    @PostMapping (value = "/{user_id}/{post_id}/retweet")
    public void repost(@PathVariable String user_id, @PathVariable String post_id){
        postService.repost(user_id, post_id);
    }

    @Operation(summary = "This endpoint adds like entry between user and post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post liked"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Something happened, could not like repost")
    })
    @PostMapping(value = "/{user_id}/{post_id}/like")
    public void likePost(@PathVariable String user_id, @PathVariable String post_id){
        postService.likePost(user_id, post_id);
    }

    @Operation(summary = "This endpoint removes like entry between user and post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post unliked"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "If you like it, admit it")
    })
    @DeleteMapping(value = "/{user_id}/{post_id}/like")
    public void unlikePost(@PathVariable String user_id, @PathVariable String post_id){
        postService.unlikePost(user_id, post_id);
    }
}
