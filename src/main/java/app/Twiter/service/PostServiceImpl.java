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
    public List<PostDTO> getUserFeed(Integer ID) {
        return null;
    }

    @Override
    public PostDTO getPostById(Integer ID) {
        return null;
    }

    @Override
    public void createPost(PostDTO postDTO, Integer userID) {

    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public void repost(Integer userId, Integer postId) {

    }

    @Override
    public void likePost(Integer userId, Integer postId) {

    }

    @Override
    public void unlikePost(Integer userId, Integer postId) {

    }

    @Override
    public void createReply(Integer userId, Integer postId, String text, String url, boolean isPublic) {

    }

    @Override
    public List<ReplyDTO> getMyPostReplies(Integer postId) {
        return null;
    }

    @Override
    public List<ReplyDTO> getPostReplies(Integer postID) {
        return null;
    }

    @Override
    public List<PostDTO> getPostsFromUser(Integer userId) {
        return null;
    }

    @Override
    public List<PostDTO> getPostsFromUserNewerThan(Integer userId, String oldestDate) {
        return null;
    }
}
