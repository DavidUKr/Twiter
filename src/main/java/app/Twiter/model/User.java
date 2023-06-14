package app.Twiter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
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

/*    public User(String username, String lastName, String firstName, String email) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.followerCount = 0;
        this.followCount = 0;
        password="";
    }*/

    public String getId() {
        return id;
    }

    public void setId(String ID) {
        this.id = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LAST_NAME) {
        this.lastName = LAST_NAME;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followersCount) {
        this.followerCount = followersCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }
}
