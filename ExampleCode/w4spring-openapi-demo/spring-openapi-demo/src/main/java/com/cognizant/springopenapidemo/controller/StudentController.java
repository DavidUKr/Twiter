package com.cognizant.springopenapidemo.controller;

import com.cognizant.springopenapidemo.model.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

  @Operation(summary = "This endpoint adds a student to the database")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Added the student",
          content = { @Content(mediaType = "application/json",
              schema = @Schema(implementation = Student.class)) }),
      @ApiResponse(responseCode = "400", description = "Bad request",
          content = @Content),
      @ApiResponse(responseCode = "500", description = "An error occured while adding the student",
          content = @Content) })
  @PostMapping
  public Student addStudent(@RequestBody Student student){
    System.out.println("Student was created");
    return null;
  }
}
