package app.Twiter.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private int ID; //TODO upgrade to unique indexing
    private String EMAIL;
    private String USERNAME;
    private String LAST_NAME;
    private String FIRST_NAME;
    private String PASSWORD;

    private Map<Integer, Post> POSTS; //index-post

    //utilities
    private int index;

    public User(int ID,String EMAIL, String USERNAME, String LAST_NAME, String FIRST_NAME, String PASSWORD){
        this.ID=ID;
        this.EMAIL=EMAIL;
        this.USERNAME=USERNAME;
        this.LAST_NAME=LAST_NAME;
        this.FIRST_NAME=FIRST_NAME;
        this.PASSWORD=PASSWORD;

        POSTS=new HashMap<>();
        index=0;
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

    public Map<Integer, Post> getPOSTS() {
        return POSTS;
    }

    public void addPOST(Post post) {
        POSTS.put(index, post);
        index++;
    }

    public List<Post> getAllPosts(){
        return POSTS.values().stream().collect(Collectors.toList());
    }



}
