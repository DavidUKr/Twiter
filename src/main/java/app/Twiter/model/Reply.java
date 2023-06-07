package app.Twiter.model;

import jakarta.persistence.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "replies")
public class Reply extends Post{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post rootPostId;

    @Column
    private boolean isPublic;

    public Reply(){}

    public Reply(User ownerId, String text, String url, LocalDate postTime, Post rootPostId, boolean isPublic) {
        super(ownerId, text, url, postTime);
        this.rootPostId = rootPostId;
        this.isPublic = isPublic;
        this.isReply=true;
    }

    public Post getRootPostId() {
        return rootPostId;
    }

    public void setRootPostId(Post rootPostId) {
        this.rootPostId = rootPostId;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}

