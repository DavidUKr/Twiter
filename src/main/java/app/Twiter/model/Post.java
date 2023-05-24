package app.Twiter.model;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumns;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Post implements Posting{
    private Integer ID;
    @NotNull
    @JoinColumns(foreignKey = " ")
    @
    private Integer ownerID;
    private Content content;
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

    public Post(Integer ownerID, Content content){
        this.ownerID=ownerID;
        this.content=content;
        LikeCount=0;
        ReplyCount=0;
        ViewCount=0;
        RepostCount=0;
        postTime=LocalDate.now();

        LIKES=new ArrayList<>();
        REPLIES=new ArrayList<>();
    }
    public Post(Integer ownerID, Content content, boolean isRepost, Integer author_id){
        this.ownerID=ownerID;
        this.content=content;
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

    @Override
    public void setID(Integer ID){
        this.ID=ID;
    }

    @Override
    public int getID(){
        return ID;
    }

    @Override
    public void addLike(Like like){
        LIKES.add(like);
        LikeCount++;
    }

    @Override
    public void removeLike(Like like) {
        LIKES.remove(like);
        LikeCount--;
    }

    @Override
    public int getLikeCount() {
        return LikeCount;
    }

    @Override
    public List<Like> getLIKES() {
        return LIKES;
    }

    @Override
    public void addReply(Reply reply) {
        REPLIES.add(reply);
        ReplyCount++;
    }

    @Override
    public void removeReply(Reply reply) {
        REPLIES.remove(reply);
    }

    @Override
    public int getReplyCount() {
        return ReplyCount;
    }

    @Override
    public List<Reply> getREPLIES() {
        return REPLIES;
    }

    @Override
    public void setOwner(Integer ownerID) {
        this.ownerID=ownerID;
    }

    @Override
    public Integer getOwner() {
        return ownerID;
    }

    @Override
    public void setContent(Content content) {
        this.content=content;
    }

    @Override
    public Content getContent() {
        return content;
    }

    @Override
    public void addView() {
        ViewCount++;
    }

    @Override
    public int getViewCount() {
        return ViewCount;
    }

    @Override
    public void addRepost() {
        RepostCount++;
    }

    public void removeRepost(){
        RepostCount--;
    }

    @Override
    public int getRepostCount() {
        return RepostCount;
    }

    public LocalDate getPostTime(){
        return postTime;
    }
}
