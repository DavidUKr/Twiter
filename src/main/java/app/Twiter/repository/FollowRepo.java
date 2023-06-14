package app.Twiter.repository;

import app.Twiter.model.Follow;
import app.Twiter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//TODO Question: do I need @Repository?

@Repository
public interface FollowRepo extends JpaRepository<Follow, String> {

    Optional<Follow> findById(String id);
    List<Follow> findAllByFollowed(User followed);
    List<Follow> findAllByFollower(User follower);
    Follow findFollowByFollowerAndFollowed(User follower, User followed);
    void deleteByFollowerAndFollowed(User follower, User followed);
    void deleteAllByFollower(User follower);
}
