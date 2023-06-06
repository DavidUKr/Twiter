package app.Twiter.util;

import app.Twiter.model.Post;
import app.Twiter.model.projections.PostDTO;

public class PostUtil {
    public PostDTO patchPostDTO(Post post){
        return new PostDTO(post.getId(), post.getOwnerId(), post.getText(), post.getUrl(), post.getLikeCount(), post.getReplyCount(), post.getViewCount(), post.getRepostCount(), post.getPostTime());
    }
}
