package app.Twiter.service;
import app.Twiter.model.Post;
import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.ReplyDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface PostService {
    List<PostDTO> getAll();
    List<PostDTO> getUserFeed(String id);
    PostDTO getPostDTOById(String id);
    Post getPostByID(String id);
    ResponseEntity.BodyBuilder createPost(PostDTO postDTO, String userId);
    ResponseEntity.BodyBuilder deletePost(String postId);
    ResponseEntity.BodyBuilder repost(String userId, String postId);
    void likePost(String userId, String postId);
    void unlikePost(String userId, String postId);
    ResponseEntity.BodyBuilder createReply(String userId, String postId, PostDTO postDTO, boolean isPublic);
    List<ReplyDTO> getMyPostReplies(String postId);
    List<ReplyDTO> getPostReplies(String postId);
    List<PostDTO> getPostsFromUser(String userId);
    List<PostDTO> getPostsFromUserNewerThan(String userId, String oldestDate);
    ResponseEntity.BodyBuilder deletePostsFromUser(String id);
}
