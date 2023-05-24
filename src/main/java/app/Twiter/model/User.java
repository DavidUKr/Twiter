package app.Twiter.model;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private int ID; //TODO upgrade to unique indexing
    @NotNull
    private String EMAIL;
    @NotNull
    private String USERNAME;
    private String LAST_NAME;
    private String FIRST_NAME;
    @NotNull
    private String PASSWORD;

    private List<Integer> POSTS; //contains post Id's
    private List<Integer> FOLLOW;
    private List<Integer> FOLLOWERS;

    public User(String EMAIL, String USERNAME, String LAST_NAME, String FIRST_NAME, String PASSWORD){
        this.EMAIL=EMAIL;
        this.USERNAME=USERNAME;
        this.LAST_NAME=LAST_NAME;
        this.FIRST_NAME=FIRST_NAME;
        this.PASSWORD=PASSWORD;

        POSTS=new ArrayList<>();
        FOLLOW=new ArrayList<>();
        FOLLOWERS=new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
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

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public List<Integer> getPOSTS() {
        return POSTS;
    }

    public void addPOST(Post post) {
        POSTS.add(post.getID());
    }
    public void removePOST(Integer id){
        POSTS.remove(id);
    }

    public List<Integer> getAllPosts(){
        return POSTS;
    }

    public List<Integer> getFOLLOW() {
        return FOLLOW;
    }

    public void addFollowing(Integer id){
        FOLLOW.add(id);
    }

    public void removeFollowing(Integer followed) {
        FOLLOW.remove(followed);
    }

    public List<Integer> getFOLLOWERS() {
        return FOLLOWERS;
    }

    public void addFollower(Integer id){
        FOLLOWERS.add(id);
    }

    public void removeFollower(Integer follower) {
        FOLLOWERS.remove(follower);
    }
}
