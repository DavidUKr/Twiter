package app.Twiter.model;

import java.util.ArrayList;
import java.util.List;

public class Reply extends Post{
    private Posting root;
    public Reply(User owner, Content content, Posting root) {
        super(owner, content);
        this.root=root;
    }
}

