package app.Twiter.repository;

import app.Twiter.model.Follow;
import app.Twiter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO Question: do I need @Repository?
@Repository
public interface FollowRepo extends JpaRepository<Follow, String> {

    Follow findById(Integer id);
    List<Follow> findAllByFollowed(User followed);
    List<Follow> findAllByFollower(User follower);
}
