package app.Twiter.service;

import app.Twiter.model.Post;

import java.util.List;

public interface IPostService {
    List<Post> getAll();

    Post getById(Integer ID);
    void createPost(Post post);
    void deletePost(Integer id);
}
