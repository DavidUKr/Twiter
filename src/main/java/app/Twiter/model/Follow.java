package app.Twiter.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer ID;

    @ManyToOne
    @JoinColumn
    private User Follower;

    @ManyToOne
    @JoinColumn
    private User Followee;
    public Follow(){}
}
