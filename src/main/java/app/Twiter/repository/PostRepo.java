package app.Twiter.repository;

import app.Twiter.model.Post;
import app.Twiter.model.Reply;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class PostRepo {
    private HashMap<Integer, Post> POSTS= new HashMap<>();
    private Integer index=0;

    public List<Post> getAll(){
        return POSTS.values().stream().collect(Collectors.toList());
    }

    //create delete
    public void createPost(Post post){
        POSTS.put(index, post);
        index++;
    }

    public void deletePost(int ID){
        POSTS.remove(ID);
    }

    public Post getPostByID(int ID){
        Post post=POSTS.get(ID);
        if(Objects.isNull(post)) throw new RuntimeException("Post "+ID+ "not found");
        return post;
    }
}
