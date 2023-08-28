package app.Twiter.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import java.time.LocalDate;

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

    public Post(User ownerId, String text, String url, boolean isRepost) {
        this.ownerId = ownerId;
        this.text = text;
        this.url = url;
        this.likeCount = 0;
        this.replyCount = 0;
        this.viewCount = 0;
        this.repostCount = 0;
        this.isRepost = isRepost;
        this.authorId = ownerId;
        this.postTime = LocalDate.now();
    }
    public Post(String text, String url, boolean isRepost) {
        this.text = text;
        this.url = url;
        this.likeCount = 0;
        this.replyCount = 0;
        this.viewCount = 0;
        this.repostCount = 0;
        this.isRepost = isRepost;
        this.postTime = LocalDate.now();
    }

    public Post(User ownerId, String text, String url) {
        this.ownerId = ownerId;
        this.text = text;
        this.url = url;
        this.likeCount = 0;
        this.replyCount = 0;
        this.viewCount = 0;
        this.repostCount = 0;
        this.postTime = LocalDate.now();
    }
    public Post(String text, String url) {
        this.text = text;
        this.url = url;
        this.likeCount = 0;
        this.replyCount = 0;
        this.viewCount = 0;
        this.repostCount = 0;
        this.postTime = LocalDate.now();
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
