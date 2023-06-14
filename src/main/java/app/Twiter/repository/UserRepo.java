package app.Twiter.repository;

import app.Twiter.model.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    //TODO Question How to implement DTO's in JPARepository
    @NotNull List<User> findAll();

    @NotNull
    Optional<User> findById(@NotNull String id);

    @Query("SELECT u FROM User u WHERE LOWER(u.username) LIKE %:searchTerm% OR LOWER(u.firstName) LIKE %:searchTerm% OR LOWER(u.lastName) LIKE %:searchTerm%")
    List<User> searchByUsernameOrFirstNameOrLastName(@Param("searchTerm") String searchTerm);

    boolean existsById(String id);

    User findByUsername(String username);
}
