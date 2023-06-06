package app.Twiter.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id; //TODO upgrade to unique indexing
    @Column(nullable = false)
    private String username;
    @Column
    private String lastName;
    @Column
    private String firstName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column
    private int followerCount;
    @Column
    private int followCount;

    public User(){}

    public User(int ID, String USERNAME, String lastName, String FIRST_NAME, String EMAIL, String PASSWORD) {
        this.id = ID;
        this.username = USERNAME;
        this.lastName = lastName;
        this.firstName = FIRST_NAME;
        this.email = EMAIL;
        this.password = PASSWORD;
        this.followerCount = 0;
        this.followCount = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String USERNAME) {
        this.username = USERNAME;
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

    public void setFirstName(String FIRST_NAME) {
        this.firstName = FIRST_NAME;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String EMAIL) {
        this.email = EMAIL;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String PASSWORD) {
        this.password = PASSWORD;
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
