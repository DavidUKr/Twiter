package app.Twiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TwiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwiterApplication.class, args);
	}

	/*TODO
<<<<<<< HEAD
	*  Interfaces for @Operations
	Make post controller not use userService
	Change User -> not contain Post
	Search for feed in postRepo, not userRepo
	Exceptions for each controller method
	Rename classes
	Remove Content Class-> text and url
	* DTO objects
=======
	* 	Add @Operation to all endpoints
	*	Exceptions for each controller method
>>>>>>> 864e917aa86fd84c6711e63505d0cb4fe670d92e
	*
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
