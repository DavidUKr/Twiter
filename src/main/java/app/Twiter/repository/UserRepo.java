package app.Twiter.repository;

import app.Twiter.model.User;
import app.Twiter.model.projections.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    //TODO Question How to implement DTO's in JPARepository
    List<User> findAll();

    User findById(Integer id);
}
