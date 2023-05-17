package app.Twiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TwiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwiterApplication.class, args);
	}

	/*TODO
	*  Interfaces for @Operations
	Make post controller not use userService
	Change User -> not contain Post
	Search for feed in postRepo, not userRepo
	Exceptions for each controller method
	Rename classes
	Remove Content Class-> text and url
	*
	* DONE:
	* Change request paths for controllers
	* */
}
