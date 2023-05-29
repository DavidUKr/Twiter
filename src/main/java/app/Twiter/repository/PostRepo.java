package app.Twiter.repository;

import app.Twiter.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository <Post, String>{

    Post findPostsByAuthor_Id(Integer authorId);


}
