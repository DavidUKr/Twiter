package app.Twiter.repository;

import app.Twiter.model.Post;
import app.Twiter.model.Reply;
import app.Twiter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepo extends JpaRepository <Post, String>{
    List<Post> findAll();

    Post findById(Integer id);
    List<Post> findAllByOwnerId(User owner);
    List<Post> findAllByOwnerIdAndPostTimeIsAfter(User owner, LocalDate date);
    void deleteByOwnerId(User owner);
}
