package app.Twiter.service;

import app.Twiter.model.Post;

import java.util.List;
//TODO change interface names
public interface IPostService {
    List<Post> getAll();

    Post getById(Integer ID);
    void createPost(Post post, Integer user_ID);
    void deletePost(Integer id);
}
