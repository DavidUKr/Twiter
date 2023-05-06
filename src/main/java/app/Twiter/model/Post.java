package app.Twiter.model;

import java.util.ArrayList;
import java.util.List;

public class Post implements Posting{
    private Integer ID;
    private User owner;
    private Content content;
    private int LikeCount;
    private int ReplyCount;

    private int ViewCount;

    private java.util.List<Like> LIKES;
    private List<Reply> REPLIES;

    public Post(User owner, Content content){
        this.owner=owner;
        this.content=content;
        LikeCount=0;
        ReplyCount=0;
        ViewCount=0;

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
    public void setOwner(User owner) {
        this.owner=owner;
    }

    @Override
    public User getOwner() {
        return owner;
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
}
