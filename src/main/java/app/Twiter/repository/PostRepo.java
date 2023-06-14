package app.Twiter.repository;

import app.Twiter.model.Post;
import app.Twiter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository <Post, String>{
    List<Post> findAll();

    Optional<Post> findById(String id);
    List<Post> findAllByOwnerId(User owner);
    List<Post> findAllByOwnerIdAndPostTimeIsAfter(User owner, LocalDate date);
    void deleteByOwnerId(User owner);
}
