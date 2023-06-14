package app.Twiter.service;

import app.Twiter.advice.exception.PostNotFoundException;
import app.Twiter.model.Like;
import app.Twiter.model.Post;
import app.Twiter.model.Reply;
import app.Twiter.model.User;
import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.ReplyDTO;
import app.Twiter.repository.*;
import app.Twiter.util.PostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepo postRepo;
    FollowRepo followRepo;
    LikeRepo likeRepo;
    ReplyRepo replyRepo;
    UserService userService;
    PostUtil postUtil;

    //CREATE
    @Override
    public ResponseEntity.BodyBuilder createPost(PostDTO postDTO, String userId) {
        if(userService.checkUserExists(userId)) {
            Post post = postUtil.patchPostFromDTO(postDTO);
            post.setOwnerId(userService.getUserByID(userId));
            postRepo.save(post);
            return ResponseEntity.status(HttpStatus.CREATED);
            //implement postCount;
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
    @Override
    public ResponseEntity.BodyBuilder repost(String userId, String postId) {
        if(checkPostExists(postId)) {
            Post post = postRepo.findById(postId).get();
            post.setRepost(true);
            post.setOwnerId(userService.getUserByID(userId));
            postRepo.save(post);
            return ResponseEntity.status(HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
    @Override
    public ResponseEntity.BodyBuilder createReply(String userId, String postId, PostDTO postDTO, boolean isPublic) {
        if(checkPostExists(postId)) {
            Reply reply=postUtil.patchReplyFromDTO(postDTO, userService.getUserByID(userId), postRepo.findById(postId).get(), isPublic);
            postRepo.save(reply);
            return ResponseEntity.status(HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

    //READ
    @Override
    public List<PostDTO> getAll() {
        return postRepo.findAll().stream()
                .map(post-> postUtil.patchPostDTO(post))
                .toList();
    }

    @Override
    public List<PostDTO> getUserFeed(String id) { //returns sorted by post time feed
        List<User> userFeedSource= followRepo
                .findAllByFollower(userService.getUserByID(id))
                .stream()
                .map(follow -> userService.getUserByID(follow.getFollowed().getId()))
                .toList();

        List<Post> feed=new ArrayList<>();
        for(User u:userFeedSource){
            feed.addAll(postRepo.findAllByOwnerId(u));
        }

        return feed
                .stream().sorted(postUtil.getDateComparator())
                .map(post -> postUtil.patchPostDTO(post))
                .toList();
    }

    @Override
    public PostDTO getPostDTOById(String id) {
        if(checkPostExists(id)) return postUtil.patchPostDTO(postRepo.findById(id).get());
        else return null;
    }

    @Override
    public Post getPostByID(String id) {
        if(checkPostExists(id)) return postRepo.findById(id).get();
        else return null;
    }
    @Override
    public List<ReplyDTO> getMyPostReplies(String postId) {
        if(checkPostExists(postId)) {
            return replyRepo.findAllByRootPostId(postRepo.findById(postId).get())
                    .stream()
                    .map(reply -> postUtil.patchReplyDTO(reply))
                    .toList();
        }
        else return null;
    }

    @Override
    public List<ReplyDTO> getPostReplies(String postId) {
        if(checkPostExists(postId)) {
            return replyRepo.findAllByRootPostId(postRepo.findById(postId).get())
                    .stream()
                    .filter(Reply::isPublic)
                    .map(reply -> postUtil.patchReplyDTO(reply))
                    .toList();
        }
        else return null;
    }

    @Override
    public List<PostDTO> getPostsFromUser(String userId) {
        return postRepo.findAllByOwnerId(userService.getUserByID(userId))
                .stream()
                .map(post -> postUtil.patchPostDTO(post))
                .toList();
    }

    @Override
    public List<PostDTO> getPostsFromUserNewerThan(String userId, String oldestDate) {
        LocalDate date_limit=LocalDate.parse(oldestDate);

        return postRepo.findAllByOwnerId(userService.getUserByID(userId))
                .stream()
                .filter(post -> post.getPostTime().isAfter(date_limit))
                .map(post -> postUtil.patchPostDTO(post))
                .toList();
    }

    //UPDATE

    @Override
    public void likePost(String userId, String postId) {
        if(checkPostExists(postId)) {
            Like like = new Like(userService.getUserByID(userId), postRepo.findById(postId).get());
            likeRepo.save(like);
            postRepo.findById(postId).get().addLike();
        }
    }

    @Override
    public void unlikePost(String userId, String postId) {
        if(checkPostExists(postId)) {
            likeRepo.deleteByOwnerIdAndPostId(userService.getUserByID(userId), postRepo.findById(postId).get());
            postRepo.findById(postId).get().removeLike();
        }
    }

    //DELETE

    @Override
    public ResponseEntity.BodyBuilder deletePost(String postId) { //deletes all likes
        if(checkPostExists(postId)){
            likeRepo.deleteAllByPostId(postRepo.findById(postId).get());
            postRepo.deleteById(postId);
            return ResponseEntity.status(HttpStatus.ACCEPTED);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity.BodyBuilder deletePostsFromUser(String id) { //also deletes all posts likes
        User user=userService.getUserByID(id);
        List<Post> userPosts=postRepo.findAllByOwnerId(user);
        for(Post p:userPosts){
            likeRepo.deleteAllByPostId(p);
        }
        postRepo.deleteByOwnerId(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED);
    }

    private boolean checkPostExists(String id){
        if(postRepo.existsById(id)) return true;
        else throw new PostNotFoundException("Post with id:"+id+" not found");
    }
}
