package app.Twiter.repository;

import app.Twiter.model.Mention;
import app.Twiter.model.Post;
import app.Twiter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentionRepo extends JpaRepository<Mention, String> {

    List<Mention> findAllByPostId(Post postId);

    List<Mention> findAllByMentioned(User mentioned);
}
