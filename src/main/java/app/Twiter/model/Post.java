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
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User ownerId;

    @Column
    private String text;
    @Column
    private URL url;

    @Column
    @Min(0)
    private int likeCount;
    @Column
    private int replyCount;
    @Column
    private int viewCount;
    @Column
    private int repostCount;
    @Column
    boolean isRepost = false;
    @Column
    Integer authorId;
    @Column
    private LocalDate postTime;


    public Post() {
    }

    public Post(Integer id, User ownerId, String text, URL url, boolean isRepost, Integer authorId, LocalDate postTime) {
        this.id = id;
        this.ownerId = ownerId;
        this.text = text;
        this.url = url;
        this.likeCount = 0;
        this.replyCount = 0;
        this.viewCount = 0;
        this.repostCount = 0;
        this.isRepost = isRepost;
        this.authorId = authorId;
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

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
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

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
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
    public void addReply(){
        replyCount++;
    }
    public void addView(){
        viewCount++;
    }
    public void addRepost(){
        replyCount++;
    }
}
