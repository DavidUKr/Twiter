package app.Twiter.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private Integer ID;
    private User owner;
    private String content;
    private Image imageContent; //subject to development
    private int Like_Count;
    private int Reply_Count;

    private int ViewCount;

    private List<Like> LIKES;
    private List<Reply> REPLIES;

    public Post(User owner, String content, int ID){
        this.ID=ID;
        this.owner=owner;
        this.content=content;
        Like_Count=0;
        Reply_Count=0;
        ViewCount=0;

        LIKES=new ArrayList<>(); //subject to development
        REPLIES=new ArrayList<>();
    }

    public Post(User owner, String content, Image imageContent, int ID){
        this.ID=ID;
        this.owner=owner;
        this.content=content;
        this.imageContent=imageContent;

        Like_Count=0;
        Reply_Count=0;
        ViewCount=0;

        LIKES=new ArrayList<>(); //subject to development
        REPLIES=new ArrayList<>();
    }

    public int getID(){
        return ID;
    }

    public void addLike(Like like){
        LIKES.add(like);
        Like_Count++;
    }
    //remove like/reply
    public void addReply(Reply reply){
        REPLIES.add(reply);
        Reply_Count++;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageContent(Image imageContent) {
        this.imageContent = imageContent;
    }

    public String getContent() {
        return content;
    }

    public Image getImageContent() {
        return imageContent;
    }

    public int getLike_Count() {
        return Like_Count;
    }

    public int getReply_Count() {
        return Reply_Count;
    }

    public List<Like> getLIKES() {
        return LIKES;
    }
    public List<Reply> getREPLIES() {
        return REPLIES;
    }

    public int getViewCount() {
        return ViewCount;
    }

    public void addView(){
        ViewCount++;
    }

}
