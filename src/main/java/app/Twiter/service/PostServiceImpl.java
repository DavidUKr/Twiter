package app.Twiter.service;

import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.ReplyDTO;
import app.Twiter.repository.PostRepo;
import app.Twiter.util.PostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepo postRepo;
    UserService userService;
    PostUtil postUtil;

    @Override
    public List<PostDTO> getAll() {
        return null;
    }

    @Override
    public List<PostDTO> getUserFeed(String ID) {
        return null;
    }

    @Override
    public PostDTO getPostById(String ID) {
        return null;
    }

    @Override
    public void createPost(PostDTO postDTO, String userID) {

    }

    @Override
    public void deletePost(String postId) {

    }

    @Override
    public void repost(String userId, String postId) {

    }

    @Override
    public void likePost(String userId, String postId) {

    }

    @Override
    public void unlikePost(String userId, String postId) {

    }

    @Override
    public void createReply(String userId, String postId, String text, String url, boolean isPublic) {

    }

    @Override
    public List<ReplyDTO> getMyPostReplies(String postId) {
        return null;
    }

    @Override
    public List<ReplyDTO> getPostReplies(String postID) {
        return null;
    }

    @Override
    public List<PostDTO> getPostsFromUser(String userId) {
        return null;
    }

    @Override
    public List<PostDTO> getPostsFromUserNewerThan(String userId, String oldestDate) {
        return null;
    }
}
