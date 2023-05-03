package app.Twiter.model;

import java.time.LocalDate;
import java.util.Date;

public class Like {
    private final User owner;
    private final Post post;
    private final LocalDate post_time;

    public Like(User owner, Post post){
        this.owner=owner;
        this.post=post;

        post_time= LocalDate.now();
    }

    public User getOwner() {
        return owner;
    }

    public Post getPost() {
        return post;
    }

    public LocalDate getPost_time() {
        return post_time;
    }

}
