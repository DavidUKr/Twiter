package app.Twiter.model;

import java.time.LocalDate;
import java.util.Date;

public class Like {
    private final Integer owner_id;
    private final Integer post_id;
    private final LocalDate like_time;

    public Like(Integer owner_id, Integer post_id){
        this.owner_id=owner_id;
        this.post_id=post_id;

        like_time= LocalDate.now();
    }
    public Integer getOwner() {
        return owner_id;
    }

    public Integer getPost() {
        return post_id;
    }

    public LocalDate getLike_time() {
        return like_time;
    }

}
