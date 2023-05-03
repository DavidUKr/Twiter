package app.Twiter.model;

import java.util.ArrayList;
import java.util.List;

public class Reply {
    private int ID;
    private final User owner;
    private String content; //subject to dev: Make a class Content which can contain multiple types;
    private List<Reply> REPLIES;

    public Reply(User owner, String content) {
        this.owner = owner;
        this.content = content;
        REPLIES = new ArrayList<>(); //subject to dev
    }

    public User getOwner() {
        return owner;
    }

    public String getContent() {
        return content;
    }

    public List<Reply> getREPLIES() {
        return REPLIES;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addReply(Reply reply){
        REPLIES.add(reply);
    }
}
