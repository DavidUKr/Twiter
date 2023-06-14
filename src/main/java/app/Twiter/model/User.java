package app.Twiter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull
    @Column
    private String lastName;

    @NotNull
    @Column
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String password;
    @Column
    private int followerCount;
    @Column
    private int followCount;

    public User(){}

    public User(@NotNull String username, @NotNull String lastName, @NotNull String firstName, @NotNull String email, @NotNull String password) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.followerCount = 0;
        this.followCount = 0;
    }

    public void addFollower(){
        followerCount++;
    }
    public void removeFollower(){
        followerCount--;
    }
    public void addFollow(){
        followCount++;
    }
    public void removeFollow(){
        followCount--;
    }

}
