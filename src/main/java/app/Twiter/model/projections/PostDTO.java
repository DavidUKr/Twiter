package app.Twiter.model.projections;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostDTO {

    private String id;
    private String ownerId;
    private String text;
    private String url;
    private int likeCount;
    private int replyCount;
    private int viewCount;
    private int repostCount;
    private LocalDate postTime;

    private List<String> mentionedIds=new ArrayList<>();

    public PostDTO() {}

    public PostDTO(String id, String ownerId, String text, String url, int likeCount, int replyCount, int viewCount, int repostCount, LocalDate postTime) {
        this.id = id;
        this.ownerId = ownerId;
        this.text = text;
        this.url = url;
        this.likeCount = likeCount;
        this.replyCount = replyCount;
        this.viewCount = viewCount;
        this.repostCount = repostCount;
        this.postTime = postTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
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

    public LocalDate getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDate postTime) {
        this.postTime = postTime;
    }

    public List<String> getMentionedIds() {
        return mentionedIds;
    }
}
