package app.Twiter.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer ID;

    @JoinColumn
    private Integer owner_id;
    @JoinColumn
    private final Integer post_id;
    @Column
    private final LocalDate like_time;
//TODO QUESTION can entity atributes be final?
    public Like(){

    }
    public Like(Integer owner_id, Integer post_id){
        this.owner_id=owner_id;
        this.post_id=post_id;

        like_time= LocalDate.now();
    }
    public Integer getOwner() {
        return owner_id;
    }

    public Integer getPost() {
        return post_id;
    }

    public LocalDate getLike_time() {
        return like_time;
    }

}
