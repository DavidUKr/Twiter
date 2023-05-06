package app.Twiter.model;

public class ReplyLike extends Like{

    private Reply reply;
    public ReplyLike(User owner, Post post, Reply reply) {
        super(owner, post);
        this.reply=reply;
    }

    public Reply getReply() {
        return reply;
    }
}
