package app.Twiter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "replies")
public class Reply extends Post{
    private Integer rootPostId;
    private boolean isPublic;

    public Reply(){}

    public Reply(Integer id, User ownerId, String text, URL url, boolean isRepost, Integer authorId, LocalDate postTime, Integer rootPostId, boolean isPublic) {
        super(id, ownerId, text, url, isRepost, authorId, postTime);
        this.rootPostId = rootPostId;
        this.isPublic = isPublic;
    }

    public Integer getRootPostId() {
        return rootPostId;
    }

    public void setRootPostId(Integer rootPostId) {
        this.rootPostId = rootPostId;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}

