package app.Twiter.service;
import app.Twiter.model.Post;
import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.ReplyDTO;
import java.util.List;
public interface PostService {
    List<PostDTO> getAll();
    List<PostDTO> getUserFeed(String id);
    PostDTO getPostDTOById(String id);
    Post getPostByID(String id);
    void createPost(PostDTO postDTO, String userId);
    void deletePost(String postId);
    void repost(String userId, String postId);
    void likePost(String userId, String postId);
    void unlikePost(String userId, String postId);
    void createReply(String userId, String postId, PostDTO postDTO, boolean isPublic);
    List<ReplyDTO> getMyPostReplies(String postId);
    List<ReplyDTO> getPostReplies(String postId);
    List<PostDTO> getPostsFromUser(String userId);
    List<PostDTO> getPostsFromUserNewerThan(String userId, String oldestDate);
    void deletePostsFromUser(String id);
}
