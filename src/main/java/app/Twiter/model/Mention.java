package app.Twiter.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="mentions")
public class Mention {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentioned")
    private User mentioned;

    public Mention(Post postId, User mentioned) {
        this.postId = postId;
        this.mentioned = mentioned;
    }

    public Mention() {}
}
