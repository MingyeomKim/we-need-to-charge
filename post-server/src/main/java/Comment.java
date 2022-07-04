import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Table(name = "COMMENT")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_idx")
    private Long comment_idx;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user_idx;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_idx")
    private Post board_idx;

    @Lob
    @Column(nullable = false)
    private String content;

    // 삭제 방법
    private boolean isRemoved = false;

    public void setWriter(User writer){
        this.user_idx = writer;
        //
    }

    public setPost(Post post){
        this.board_idx = post;
        post.addComment(this);
    }

    // 수정은 못 하는 걸로
    // 삭제
    public void remove(){
        this.isRemoved = true;
    }

    @Builder
    public Comment(User writer, Post post, String content){
        this.user_idx = writer;
        this.board_idx = post;
        this.content = content;
        this.isRemoved = false;
    }
}
