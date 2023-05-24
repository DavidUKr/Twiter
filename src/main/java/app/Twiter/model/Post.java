package app.Twiter.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Post{
    private Integer ID;
    @NotNull
    private Integer ownerID;
    private String text;
    private URL url;
    @Min(0)
    private int LikeCount;
    private int ReplyCount;
    private int ViewCount;
    private int RepostCount;
    boolean isRepost=false;
    Integer author_Id;
    private LocalDate postTime;
    private java.util.List<Like> LIKES;
    private List<Reply> REPLIES;

    public Post(Integer ownerID, String text, URL url){
        this.ownerID=ownerID;
        this.text=text;
        this.url=url;
        LikeCount=0;
        ReplyCount=0;
        ViewCount=0;
        RepostCount=0;
        postTime=LocalDate.now();

        LIKES=new ArrayList<>();
        REPLIES=new ArrayList<>();
    }
    public Post(Integer ownerID, String text, URL url, boolean isRepost, Integer author_id){
        this.ownerID=ownerID;
        this.text=text;
        this.url=url;
        LikeCount=0;
        ReplyCount=0;
        ViewCount=0;
        RepostCount=0;
        postTime=LocalDate.now();

        this.isRepost=isRepost;
        this.author_Id=author_id;

        LIKES=new ArrayList<>();
        REPLIES=new ArrayList<>();
    }

    public void setID(Integer ID){
        this.ID=ID;
    }

    public int getID(){
        return ID;
    }

    public void addLike(Like like){
        LIKES.add(like);
        LikeCount++;
    }

    public void removeLike(Like like) {
        LIKES.remove(like);
        LikeCount--;
    }

    public int getLikeCount() {
        return LikeCount;
    }

    public List<Like> getLIKES() {
        return LIKES;
    }

    public void addReply(Reply reply) {
        REPLIES.add(reply);
        ReplyCount++;
    }

    public void removeReply(Reply reply) {
        REPLIES.remove(reply);
    }

    public int getReplyCount() {
        return ReplyCount;
    }

    public List<Reply> getREPLIES() {
        return REPLIES;
    }

    public void setOwner(Integer ownerID) {
        this.ownerID=ownerID;
    }

    public Integer getOwner() {
        return ownerID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void addView() {
        ViewCount++;
    }

    public int getViewCount() {
        return ViewCount;
    }

    public void addRepost() {
        RepostCount++;
    }

    public void removeRepost(){
        RepostCount--;
    }

    public int getRepostCount() {
        return RepostCount;
    }

    public LocalDate getPostTime(){
        return postTime;
    }
}
