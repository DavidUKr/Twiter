package app.Twiter.model;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public interface Posting {
    void setID(Integer ID);
    int getID();
    void addLike(Like like);
    void removeLike(Like like);
    int getLikeCount();
    List<Like> getLIKES();
    void addReply(Reply reply);
    void removeReply(Reply reply);
    int getReplyCount();
    List<Reply> getREPLIES();
    void setOwner(Integer userID);
    Integer getOwner();
    void setContent(Content content);
    Content getContent();
    void addView();
    int getViewCount();
    LocalDate getPostTime();
}
