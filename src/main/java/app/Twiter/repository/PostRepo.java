package app.Twiter.repository;

import app.Twiter.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository <Post, String>{
    @Query
    List<Post> findAll();

    @Query
    Post findById(Integer id);

    @Query
    List<Post> findAllByOwnerId(Integer ownerId);
}
