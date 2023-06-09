package app.Twiter.model.projections;

import app.Twiter.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReplyDTO extends PostDTO{

    private String rootPostId;
    private boolean isPublic;

    public ReplyDTO(){
        super();
    }
    public ReplyDTO(String id, String ownerId, String text, String url, int likeCount, int replyCount, int viewCount, int repostCount, LocalDate postTime, String rootPostId, boolean isPublic) {
        super(id, ownerId, text, url, likeCount, replyCount, viewCount, repostCount, postTime);
        this.rootPostId = rootPostId;
        this.isPublic = isPublic;
    }

    public String getRootPostId() {
        return rootPostId;
    }

    public void setRootPostId(String rootPostId) {
        this.rootPostId = rootPostId;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
