package app.Twiter.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User followed;

    @Column
    private LocalDate followTime;
    public Follow(){}

    public Follow(User follower, User followed) {
        this.follower = follower;
        this.followed = followed;
        this.followTime = LocalDate.now();
    }
}
