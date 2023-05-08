package app.Twiter.service;

import app.Twiter.model.Post;
import app.Twiter.model.User;
import app.Twiter.repository.PostRepo;
import app.Twiter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService_impl implements PostService{

    PostRepo postRepo;
    UserRepo userRepo;
    @Autowired
    public PostService_impl(PostRepo postRepo, UserRepo  userRepo){
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
    public void deletePost(Integer ID) {
        postRepo.deletePost(ID);
    }


    @Override
    public List<Post> getUserFeed(Integer ID) {
        ArrayList<Post> feed=new ArrayList<Post>();

        ArrayList<Integer> follow_list= (ArrayList<Integer>) userRepo.getUserByID(ID).getFOLLOW();
        for(Integer user_id:follow_list){
            feed.addAll(userRepo.getUserByID(user_id).getPOSTS().values());
        }

        return feed;
    }
}
