package app.Twiter.controller;

import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/users")
public interface UserController {
    @Operation(summary = "This endpoint adds Users")
    @Parameters(value = {
            @Parameter(name = "UserDTO", description = "body that contains the data that characterizes a User, containing only basic info",
                    example = "\"userName\":\"JohnTheBear\", \"firstName\":\"Ioan Flavius\", \"lastName\":\"Urs\", \"email\":\"IoanFlaviusUrs@gmail.com\", \"password\":\"12345678\"")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User added",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PostDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request",content = @Content),
            @ApiResponse(responseCode = "422", description = "Do better at describing your user", content = @Content),
            @ApiResponse(responseCode = "500", description = "Something happened, could not add user",content = @Content)
    })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void registerUser(@RequestBody UserDTO userDTO);

    @Operation(summary = "Returns all users")
    @ApiResponses(value={
            @ApiResponse(responseCode = "226", description = "Here is your data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Something happened", content= @Content)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> getAllUsers();

    @Operation(summary = "Returns one user DTO based on path id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "226", description = "Here is your user DTO",
            content = {@Content(mediaType = "application/json",
                schema=@Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "502", description = "Database not working properly")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getUserById(@PathVariable String id);

    @Operation(summary = "Returns a list of UserDTO's based on parameter name; it searches matches for username, first name and last name; returns results containing {name}")
    @Parameter(name = "name", description = "search input for username/first name/ last name", example = "\"name\":\"Ioan\"")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "226", description = "Here is your user DTO",
                    content = {@Content(mediaType = "application/json",
                            schema=@Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "404", description = "No user found"),
            @ApiResponse(responseCode = "500", description = "Something happened")
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> searchUserByName(@RequestParam String name);

    @Operation(summary = "Updates user with input data based on path id. Modifies only what is given")
    @Parameter(name = "userDTO", description = "Body that contains data to change", example = "\"password\":\"87654321\"")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated"),
            @ApiResponse(responseCode = "404", description = "No user found"),
            @ApiResponse(responseCode = "500", description = "Something happened")
    })
    @PatchMapping(value = "/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
    void patchUser(@PathVariable String id, @RequestBody UserDTO userDTO);

    @Operation(summary = "Unregisters user based on path id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "User queried for delete"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Something happened")
    })
    @DeleteMapping(value = "/{id}")
    void unregisterUser(@PathVariable String id);
}
