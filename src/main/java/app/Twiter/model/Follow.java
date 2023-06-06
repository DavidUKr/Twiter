package app.Twiter.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User Follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User Followee;

    @Column
    private LocalDate followTime;
    public Follow(){}

    public Follow(Integer ID, User follower, User followee) {
        this.ID = ID;
        Follower = follower;
        Followee = followee;
        this.followTime = LocalDate.now();
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public User getFollower() {
        return Follower;
    }

    public void setFollower(User follower) {
        Follower = follower;
    }

    public User getFollowee() {
        return Followee;
    }

    public void setFollowee(User followee) {
        Followee = followee;
    }

    public LocalDate getFollowTime() {
        return followTime;
    }

    public void setFollowTime(LocalDate followTime) {
        this.followTime = followTime;
    }
}
