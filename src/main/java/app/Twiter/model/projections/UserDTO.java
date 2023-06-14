package app.Twiter.model.projections;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
    private String id;
    private String userName;
    private String lastName;
    private String firstName;
    private String email;
    private String password=null;
    private int followerCount;
    private int followCount;

    public UserDTO() {}

    public UserDTO(String id, String userName, String lastName, String firstName, String email, int followerCount, int followCount) {
        this.id=id;
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.followerCount = followerCount;
        this.followCount = followCount;
    }
    public UserDTO(String id, String userName, String lastName, String firstName, String email, int followerCount, int followCount, String password) {
        this.id=id;
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.followerCount = followerCount;
        this.followCount = followCount;
        this.password=password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
