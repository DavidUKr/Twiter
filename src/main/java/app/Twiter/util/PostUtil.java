package app.Twiter.util;

import app.Twiter.model.Post;
import app.Twiter.model.Reply;
import app.Twiter.model.User;
import app.Twiter.model.projections.PostDTO;
import app.Twiter.model.projections.ReplyDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;

@Component
public class PostUtil {
    public Post patchPostFromDTO(PostDTO postDTO){
        return new Post(postDTO.getText(), postDTO.getUrl());
    }
    public Reply patchReplyFromDTO(PostDTO postDTO, User userId, Post postId, boolean isPublic){
        return new Reply(userId, postDTO.getText(), postDTO.getUrl(), postId, isPublic);
    }

    public PostDTO patchPostDTO(Post post){
        return new PostDTO(post.getId(), post.getOwnerId().getId(), post.getText(), post.getUrl(), post.getLikeCount(), post.getReplyCount(), post.getViewCount(), post.getRepostCount(), post.getPostTime());
    }

    public ReplyDTO patchReplyDTOfromPost(Post post){
        return new ReplyDTO(post.getId(), post.getOwnerId().getId(), post.getText(), post.getUrl(), post.getLikeCount(), post.getReplyCount(), post.getViewCount(), post.getRepostCount(), post.getPostTime(), ((Reply)post).getRootPostId().getId(), ((Reply)post).isPublic());
    }

    public ReplyDTO patchReplyDTO(Reply reply){
        return new ReplyDTO(reply.getId(), reply.getOwnerId().getId(), reply.getText(), reply.getUrl(), reply.getLikeCount(), reply.getReplyCount(), reply.getViewCount(), reply.getRepostCount(), reply.getPostTime(), reply.getRootPostId().getId(), reply.isPublic());
    }

    public PostDateComparator getDateComparator(){
        return new PostDateComparator();
    }

}

class PostDateComparator implements Comparator<Post> {
    @Override
    public int compare(Post o1, Post o2) {
        LocalDate date=o1.getPostTime();
        int o1DateAsInt=date.getYear()*10000+date.getMonthValue()*100+date.getDayOfMonth();
        date=o2.getPostTime();
        int o2DateAsInt=date.getYear()*10000+date.getMonthValue()*100+date.getDayOfMonth();

        return o1DateAsInt-o2DateAsInt;
    }
}