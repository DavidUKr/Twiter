package app.Twiter.model;

import java.util.ArrayList;
import java.util.List;

public class Reply extends Post{
    private Integer rootPost_id;
    private boolean isPublic;
    public Reply(Integer owner_id, Content content, Integer rootPost_id, boolean isPublic) {
        super(owner_id, content);
        this.rootPost_id=rootPost_id;
        this.isPublic=isPublic;
    }

    public Integer getRootPost_id() {
        return rootPost_id;
    }

    public boolean isPublic() {
        return isPublic;
    }
}

