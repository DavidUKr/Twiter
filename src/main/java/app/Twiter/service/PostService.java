package app.Twiter.service;

import app.Twiter.model.Post;

import java.util.List;
public interface PostService {
    List<Post> getAll();

    Post getById(Integer ID);
    void createPost(Post post, Integer user_ID);
    void deletePost(Integer id);
}
