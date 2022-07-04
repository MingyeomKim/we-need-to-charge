import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "LikeOfBoard")
@Getter
@NoArgsConstructor
@Entity
public class LikeOfBoard {
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_idx")
    private Post board_idx;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user_idx;

    @Column(name = "like_idx")
    private Integer like_idx = 0;

    // type은 지우쟈..

    LikfOfBoard(User user, Post post){
        this.user_idx = user;
        this.board_idx = post;
        this.like_idx++;
    }
}
