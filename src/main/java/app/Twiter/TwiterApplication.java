package app.Twiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TwiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwiterApplication.class, args);
	}

	/*TODO
	* 		DTO objects
	* 		Add @Operation to all endpoints
	*		Exceptions for each controller method
	* 		Implement JPA repos
	* 		Test Swagger
	* 		Implement Liquibase
	* 		Implement Lombok
	* 		Implement Mapstruct
	* 		Test with junit
	* DONE:
	* 	Change request paths for controllers
	*   Interfaces for @Operations
	* 	Make post controller not use userService
	* 	Change User -> not contain Post
	* 	Search for feed in postRepo, not userRepo
	* 	Rename classes
	* 	Remove Content Class-> text and url
	* */
}
