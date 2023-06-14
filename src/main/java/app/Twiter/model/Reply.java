package app.Twiter.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
//@Table(name = "replies")
@Data
public class Reply extends Post{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post rootPostId;

    @Column
    private boolean isPublic;

    public Reply(){}

    public Reply(User ownerId, String text, String url, Post rootPostId, boolean isPublic) {
        super(ownerId, text, url, false);
        this.rootPostId = rootPostId;
        this.isPublic = isPublic;
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

