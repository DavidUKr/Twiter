package app.Twiter.model;

import jakarta.persistence.*;

@Entity
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public User getMentioned() {
        return mentioned;
    }

    public void setMentioned(User mentioned) {
        this.mentioned = mentioned;
    }
}
