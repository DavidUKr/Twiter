package app.Twiter.model.projections;

import app.Twiter.model.User;

import java.time.LocalDate;

public class ReplyDTO extends PostDTO{

    private int rootPostId;
    private boolean isPublic;

    public ReplyDTO(int id, User ownerId, String text, String url, int likeCount, int replyCount, int viewCount, int repostCount, LocalDate postTime, int rootPostId, boolean isPublic) {
        super(id, ownerId, text, url, likeCount, replyCount, viewCount, repostCount, postTime);
        this.rootPostId = rootPostId;
        this.isPublic = isPublic;
    }

    public int getRootPostId() {
        return rootPostId;
    }

    public void setRootPostId(int rootPostId) {
        this.rootPostId = rootPostId;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
