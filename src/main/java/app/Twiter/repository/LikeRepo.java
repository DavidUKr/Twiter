package app.Twiter.repository;

import app.Twiter.model.Like;
import app.Twiter.model.Post;
import app.Twiter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepo extends JpaRepository<Like, String> {
    Like findByID(Integer id);

    //TODO Question Recomended?
    List<Like> findAllByOwnerIdOrPostId(User user, Post post);

    List<Like> findAllByOwnerId(User user);
    List<Like> findAllByPostId(Post post);
    void deleteAllByOwnerId(User Owner);
    void deleteAllByPostId(Post post);
    void deleteByOwnerIdAndPostId(User owner, Post post);
}
