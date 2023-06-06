package app.Twiter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int ID; //TODO upgrade to unique indexing
    @Column(nullable = false)
    private String USERNAME;
    @Column
    private String LAST_NAME;
    @Column
    private String FIRST_NAME;
    @Column(nullable = false)
    private String EMAIL;
    @Column(nullable = false)
    private String PASSWORD;
    @Column
    private int followersCount;
    @Column
    private int followCount;

    public User(){}

    public User(int ID, String USERNAME, String LAST_NAME, String FIRST_NAME, String EMAIL, String PASSWORD) {
        this.ID = ID;
        this.USERNAME = USERNAME;
        this.LAST_NAME = LAST_NAME;
        this.FIRST_NAME = FIRST_NAME;
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
        this.followersCount = 0;
        this.followCount = 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }
}
