package app.Twiter.service;

import app.Twiter.model.Post;
import app.Twiter.model.Reply;

import java.net.URL;
import java.util.List;
public interface PostService {
    List<Post> getAll();
    List<Post> getUserFeed(Integer ID);
    Post getPostById(Integer ID);
    void createPost(Post post, Integer userID);
    void deletePost(Integer postId);
    void repost(Integer userId, Integer postId);
    void likePost(Integer userId, Integer postId);
    void unlikePost(Integer userId, Integer postId);
    void createReply(Integer userId, Integer postId, String text, URL url, boolean isPublic);
    List<Reply> getMyPostReplies(Integer postId);
    List<Reply> getPostReplies(Integer postID);

    List<Post> getPostsFromUser(Integer userId);

    List<Post> getPostsFromUserNewerThan(Integer userId, String oldestDate);
}
