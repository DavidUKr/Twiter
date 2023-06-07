package app.Twiter.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;


import javax.swing.text.View;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    protected User ownerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    protected User authorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    protected User rootPostOwnerId=null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    protected Post rootPostId=null;

    @Column
    protected String text;
    @Column
    protected String url;

    @Column
    @Min(0)
    protected int likeCount;
    @Column
    protected int replyCount;
    @Column
    protected int viewCount;
    @Column
    protected int repostCount;
    @Column
    protected boolean isRepost = false;
    @Column
    protected LocalDate postTime;
    @Column
    protected boolean isReply=false;


    public Post() {
    }

    public Post(User ownerId, String text, String url, boolean isRepost, LocalDate postTime) {
        this.ownerId = ownerId;
        this.text = text;
        this.url = url;
        this.likeCount = 0;
        this.replyCount = 0;
        this.viewCount = 0;
        this.repostCount = 0;
        this.isRepost = isRepost;
        this.authorId = ownerId;
        this.postTime = postTime;
    }

    public Post(User ownerId, String text, String url, LocalDate postTime) {
        this.ownerId = ownerId;
        this.text = text;
        this.url = url;
        this.likeCount = 0;
        this.replyCount = 0;
        this.viewCount = 0;
        this.repostCount = 0;
        this.postTime = postTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getRepostCount() {
        return repostCount;
    }

    public void setRepostCount(int repostCount) {
        this.repostCount = repostCount;
    }

    public boolean isRepost() {
        return isRepost;
    }

    public void setRepost(boolean repost) {
        isRepost = repost;
    }

    public User getAuthorId() {
        return authorId;
    }

    public void setAuthorId(User authorId) {
        this.authorId = authorId;
    }

    public LocalDate getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDate postTime) {
        this.postTime = postTime;
    }

    public void addLike(){
        likeCount++;
    }
    public void removeLike(){
        likeCount--;
    }
    public void addReply(){
        replyCount++;
    }
    public void removeReply(){
        replyCount--;
    }
    public void addView(){
        viewCount++;
    }
    public void removeView(){
        viewCount--;
    }
    public void addRepost(){
        replyCount++;
    }
    public void removeRepost(){
        replyCount--;
    }
}
