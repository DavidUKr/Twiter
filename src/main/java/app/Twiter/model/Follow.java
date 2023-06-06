package app.Twiter.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User followed;

    @Column
    private LocalDate followTime;
    public Follow(){}

    public Follow(User follower, User followee) {
        this.follower = follower;
        followed = followee;
        this.followTime = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer ID) {
        this.id = ID;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

    public LocalDate getFollowTime() {
        return followTime;
    }

    public void setFollowTime(LocalDate followTime) {
        this.followTime = followTime;
    }
}
