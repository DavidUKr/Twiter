package app.Twiter.service;
import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.ReplyDTO;
import java.util.List;
public interface PostService {
    List<PostDTO> getAll();
    List<PostDTO> getUserFeed(Integer ID);
    PostDTO getPostById(Integer ID);
    void createPost(PostDTO postDTO, Integer userID);
    void deletePost(Integer postId);
    void repost(Integer userId, Integer postId);
    void likePost(Integer userId, Integer postId);
    void unlikePost(Integer userId, Integer postId);
    void createReply(Integer userId, Integer postId, String text, String url, boolean isPublic);
    List<ReplyDTO> getMyPostReplies(Integer postId);
    List<ReplyDTO> getPostReplies(Integer postID);
    List<PostDTO> getPostsFromUser(Integer userId);
    List<PostDTO> getPostsFromUserNewerThan(Integer userId, String oldestDate);
}
