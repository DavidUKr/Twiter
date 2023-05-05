package app.Twiter.service;

import app.Twiter.model.Post;
import app.Twiter.model.User;
import app.Twiter.repository.PostRepo;
import app.Twiter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{

    PostRepo postRepo;
    UserRepo userRepo;
    @Autowired
    public PostService(PostRepo postRepo, UserRepo  userRepo){
        this.postRepo=postRepo;
        this.userRepo=userRepo;
    }
    @Override
    public List<Post> getAll() {
        return postRepo.getAll();
    }

    @Override
    public Post getById(Integer ID) {
        return postRepo.getPostByID(ID);
    }

    @Override
    public void createPost(Post post, Integer user_ID) {
        postRepo.createPost(post);
        User user=userRepo.getUserByID(user_ID);
        user.addPOST(post);
    }

    @Override
    public void deletePost(Integer ID) {
        postRepo.deletePost(ID);
    }
}
