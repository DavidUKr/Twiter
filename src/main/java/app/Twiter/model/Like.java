package app.Twiter.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User ownerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post postId;

    @Column
    private LocalDate likeTime;
    public Like(){}

    public Like(User ownerId, Post postId) {
        this.ownerId = ownerId;
        this.postId = postId;
        this.likeTime = LocalDate.now();
    }
}
