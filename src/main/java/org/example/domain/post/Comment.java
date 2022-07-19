package org.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Comment")
public class Comment extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CommentIdx")
    private Long commentIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User userIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardIdx")
    private Board boardIdx;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(name = "likeNum")
    private Long likeNum;

    public Comment(Long idx, User userIdx, Board boardIdx, String content){
        this.commentIdx = idx;
        this.userIdx = userIdx;
        this.boardIdx = boardIdx;
        this.content = content;
        this.likeNum = 0L;
    }
}
