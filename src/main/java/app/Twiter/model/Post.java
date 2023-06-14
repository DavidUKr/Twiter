package app.Twiter.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;


import javax.swing.text.View;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    protected User ownerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    protected User authorId;

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
    public Post(String text, String url, boolean isRepost, LocalDate postTime) {
        this.text = text;
        this.url = url;
        this.likeCount = 0;
        this.replyCount = 0;
        this.viewCount = 0;
        this.repostCount = 0;
        this.isRepost = isRepost;
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
    public Post(String text, String url, LocalDate postTime) {
        this.text = text;
        this.url = url;
        this.likeCount = 0;
        this.replyCount = 0;
        this.viewCount = 0;
        this.repostCount = 0;
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
