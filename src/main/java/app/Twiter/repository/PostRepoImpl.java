package app.Twiter.repository;

import app.Twiter.model.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo{
    private HashMap<Integer, Post> POSTS= new HashMap<>();
    private Integer index=0; //TODO update inedxing system

    public List<Post> getAll(){
        return POSTS.values().stream().collect(Collectors.toList());
    }

    //CREATE
    public void createPost(Post post){
        post.setID(index);
        POSTS.put(index, post);
        index++;
    }

    //READ
    public Post getPostByID(int ID){
        Post post=POSTS.get(ID);
        if(Objects.isNull(post)) throw new RuntimeException("Post "+ID+ "not found");
        return post;
    }

    //UPDATE

    //DELETE
    public void deletePost(int ID){
        POSTS.remove(ID);
    }
}
