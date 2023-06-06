package app.Twiter.repository;

import app.Twiter.model.Reply;
import app.Twiter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepo extends JpaRepository<Reply, String> {


    List<Reply> findAllByRootPostId(Integer rootPostId);
    List<Reply> findAllByOwnerId(User ownerId);
}
