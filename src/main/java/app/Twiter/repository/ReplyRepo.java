package app.Twiter.repository;

import app.Twiter.model.Post;
import app.Twiter.model.Reply;
import app.Twiter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepo extends JpaRepository<Reply, String> {

    List<Reply> findAllByRootPostId(Post rootPostId);
    List<Reply> findAllByOwnerId(User ownerId);
}
