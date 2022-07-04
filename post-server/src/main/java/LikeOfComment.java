import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "LikeOfComment")
@Getter
@NoArgsConstructor
@Entity
public class LikeOfComment {
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_idx")
    private Comment comment_idx;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user_idx;

    @Column(name = "like_idx")
    private Integer like_idx = 0;

    // type은 지우쟈..

    LikfOfComment(User user, Comment comment){
        this.user_idx = user;
        this.comment_idx = comment;
        this.like_idx++;
    }
}
