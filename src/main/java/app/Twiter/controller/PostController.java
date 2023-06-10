package app.Twiter.controller;

import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.ReplyDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Content;

@RestController
@RequestMapping(value="/api/v1/posts/")
public interface PostController {

    //CREATE
    @Operation(summary = "This endpoint adds post")
    @Parameters(value = {
            @Parameter(name = "postDTO", description = "body that contains the data that characterizes a post, containing only basic info",
            example = "\"text\":\"This is not acceptable, the government is going nuts\", \"url\":\"some conent url\"")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post added",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PostDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Something happened, could not add post")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void addPostToUser(@PathVariable String user_id, @RequestBody PostDTO postDTO);

    @Operation(summary = "Creates Reply to a given by id post")
    @Parameters(value = {
            @Parameter(name = "postDTO", description = "Body that contains reply data",
                    example = "\"text\":\"This dude is crazy\", \"url\":\"some conent url\""),
            @Parameter(name= "isPublic", description = "boolean - specifies if reply is public or not")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reply created"),
            @ApiResponse(responseCode = "404", description = "Id not found"),
            @ApiResponse(responseCode = "500", description = "Something happened")
    })
    @PostMapping (value = "/feed/{post_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void replyPost(@PathVariable String user_id, @PathVariable String post_id, @RequestBody PostDTO postDTO, @RequestParam boolean isPublic);

    //READ
    @Operation(summary = "Returns list of logged user's postDTO's")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "226", description = "Here are your posts",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PostDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Something happened, could not return posts")
    })
    @GetMapping(value="/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getMyPosts(@PathVariable String user_id);

    @Operation(summary = "Returns list of postDTO's filtered by date: newer than")
    @Parameters(value = {
            @Parameter(name = "oldestDate", description = "Date limit for returning posts newer than. Format:year/month/day -> as one integer",
                    example = "\"oldestDate\":\"20120717\"")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are your latest posts",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PostDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Something happened. could not return posts")
    })
    @GetMapping(value = "/{user_id}/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getMyPostsNewerThan(@PathVariable String user_id, @RequestParam String oldestDate);

    @Operation(summary = "Returns all replyDTO's of a post based on post id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are your replies",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PostDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Post not found"),
            @ApiResponse(responseCode = "500", description = "Something happened. could not return posts")
    })
    @GetMapping(value = "/{post_id}/my_replies", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ReplyDTO> getMyPostReplies(@PathVariable String post_id);

    @Operation(summary = "Returns only public replyDTO's of a post based on post id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Here are the replies",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PostDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Post not found"),
            @ApiResponse(responseCode = "500", description = "Something happened. could not return posts")
    })
    @GetMapping(value = "/{post_id}/replies", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ReplyDTO> getPostReplies(@PathVariable String post_id);

    //DELETE
    @Operation(summary = "Deletes post based on path id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Post queried for delete"),
            @ApiResponse(responseCode = "404", description = "Post not found"),
            @ApiResponse(responseCode = "500", description = "Something happened")
    })
    @DeleteMapping( value = "/{post_id}")
    void deletePost(@RequestParam String post_id);
}
