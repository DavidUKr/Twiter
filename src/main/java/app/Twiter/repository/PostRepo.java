package app.Twiter.repository;

import app.Twiter.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository <Post, String>{

    @Query("SELECT p FROM Post p")
    List<Post> getAll();

    @Query("INSERT INTO Post p")
    Object save(Post post);
    //TODO QUESTION DO YOU NEED IMPLEMENTATION?

}
