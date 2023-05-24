package app.Twiter.repository;

import app.Twiter.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepo extends JpaRepository<Reply, String> {
}
