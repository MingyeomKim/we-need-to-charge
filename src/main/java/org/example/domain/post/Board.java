package org.example.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.user.User;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "BOARD")
public class Board extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardIdx")
    private Long boardIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User userIdx;

    @Column(nullable = false)
    private String category;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private Long likeNum;

    @Builder
    public Board(Long idx, User userIdx, String category, String title, String content){
        this.boardIdx = idx;
        this.userIdx = userIdx;
        this.category = category;
        this.title = title;
        this.content = content;
        likeNum = 0L;
    }
}
