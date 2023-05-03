package app.Twiter.service;

import app.Twiter.model.Post;
import app.Twiter.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{

    PostRepo postRepo;
    @Autowired
    public PostService(PostRepo postRepo){
        this.postRepo=postRepo;
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
    public void createPost(Post post) {
        postRepo.createPost(post);
    }

    @Override
    public void deletePost(Integer ID) {
        postRepo.deletePost(ID);
    }
}
