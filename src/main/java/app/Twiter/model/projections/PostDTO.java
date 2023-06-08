package app.Twiter.model.projections;

import app.Twiter.model.User;

import java.time.LocalDate;

public class PostDTO {

    private int id;
    private User ownerId;
    private String text;
    private String url;
    private int likeCount;
    private int replyCount;
    private int viewCount;
    private int repostCount;
    private LocalDate postTime;

    public PostDTO(int id, User ownerId, String text, String url, int likeCount, int replyCount, int viewCount, int repostCount, LocalDate postTime) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDate postTime) {
        this.postTime = postTime;
    }
}
