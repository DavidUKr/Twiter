package app.Twiter.repository;

import app.Twiter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    //TODO Question How to implement DTO's in JPARepository
    List<User> findAll();

    Optional<User> findById(String id);

    List<User> findAllByUsernameRegexOrFirstNameRegexOrLastNameRegex(String name);

    boolean existsById(String id);
}
