package app.Twiter.service;

import app.Twiter.model.*;
import app.Twiter.repository.PostRepoImpl;
import app.Twiter.repository.UserRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    PostRepoImpl postRepo;
    UserRepoImpl userRepo;
    @Autowired
    public PostServiceImpl(PostRepoImpl postRepo, UserRepoImpl userRepo){
        this.postRepo=postRepo;
        this.userRepo=userRepo;
    }
    @Override
    public List<Post> getAll() {
        return postRepo.getAll();
    }

    @Override
    public Post getPostById(Integer ID) {
        return postRepo.getPostByID(ID);
    }

    @Override
    public void createPost(Post post, Integer user_ID) {
        postRepo.createPost(post);
        post.setOwner(user_ID);
        User user=userRepo.getUserByID(user_ID);
        user.addPOST(post);
    }

    @Override
    public void createReply(Integer userId, Integer postId, String text, URL url, boolean isPublic) {
        Reply reply=new Reply(userId, text, url, postId, isPublic, postRepo.getPostByID(postId).getOwner());
        userRepo.getUserByID(userId).addPOST(reply);
        postRepo.getPostByID(postId).addReply(reply);
    }

    @Override
    public List<Reply> getMyPostReplies(Integer postId) {
        return postRepo.getPostByID(postId).getREPLIES();
    }

    @Override
    public List<Reply> getPostReplies(Integer postID) {
        return postRepo.getPostByID(postID).getREPLIES().stream()
                .filter(Reply::isPublic)
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getPostsFromUser(Integer userId) {
        //TODO Question can postservice acces userRepo?
        List<Integer> post_ids=userRepo.getUserPosts(userId);
        List<Post> POSTS=new ArrayList<>();

        for(Integer id: post_ids){
            POSTS.add(postRepo.getPostByID(id));
        }

        return POSTS;
    }

    @Override
    public List<Post> getPostsFromUserNewerThan(Integer userId, String oldestDate) {
        List<Post> POSTS=getPostsFromUser(userId);
        LocalDate date_limit=LocalDate.parse(oldestDate);
        return POSTS.stream().filter(post -> post.getPostTime().isAfter(date_limit)).collect(Collectors.toList());
    }

    @Override
    public void repost(Integer userId, Integer postId) {
        Post original=getPostById(postId);
        //TODO QUESTION: Better add instance or just reference?
        original.addRepost();
        Post post=new Post(userId, original.getText(), original.getUrl(), true, original.getOwner());
        createPost(post, userId);
    }

    @Override
    public void likePost(Integer user_id, Integer post_id) {
        Like like=new Like(user_id, post_id);
        postRepo.getPostByID(post_id).addLike(like);
    }

    @Override
    public void unlikePost(Integer userId, Integer postId) {

        Like likeToRemove=getPostById(postId).getLIKES().stream()
                .filter(like -> like.getOwner()==userId)
                .findFirst().get();
        if(likeToRemove!=null)
            postRepo.getPostByID(postId).removeLike(likeToRemove);
    }

    @Override
    public void deletePost(Integer ID) {

        Integer owner_id=postRepo.getPostByID(ID).getOwner();
        userRepo.getUserByID(owner_id).removePOST(ID);
        postRepo.getPostByID(ID).getLIKES().clear(); //remove all likes
        postRepo.getPostByID(ID).getREPLIES().clear(); //remove all replies
        postRepo.deletePost(ID);
    }


    @Override
    public List<Post> getUserFeed(Integer ID) {
        ArrayList<Post> feed=new ArrayList<Post>();

        ArrayList<Integer> follow_list= (ArrayList<Integer>) userRepo.getUserByID(ID).getFOLLOW();
        for(Integer user_id:follow_list){
            feed.addAll(getPostsFromUser(user_id));
        }

        return feed;
    }


}
