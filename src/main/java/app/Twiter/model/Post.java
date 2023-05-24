package app.Twiter.model;

import io.swagger.v3.oas.annotations.media.Content;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ManyToAny;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer ID;

    @ManyToOne
    @JoinColumn(name="owner_id", nullable = false)
    private Integer ownerID;

    @Column
    private String text;
    @Column
    private URL url;

    @Column
    @Min(0)
    private int LikeCount;
    @Column
    private int ReplyCount;
    @Column
    private int ViewCount;
    @Column
    private int RepostCount;
    @Column
    boolean isRepost=false;
    @Column
    Integer author_Id;
    @Column
    private LocalDate postTime;

    private java.util.List<Like> LIKES;
    private List<Reply> REPLIES;

    public Post(){}
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
