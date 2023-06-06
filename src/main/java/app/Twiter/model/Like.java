package app.Twiter.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User ownerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post postId;

    @Column
    private LocalDate likeTime;
    public Like(){}

    public Like(Integer ID, User ownerId, Post postId) {
        this.ID = ID;
        this.ownerId = ownerId;
        this.postId = postId;
        this.likeTime = LocalDate.now();
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public LocalDate getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(LocalDate likeTime) {
        this.likeTime = likeTime;
    }
}
