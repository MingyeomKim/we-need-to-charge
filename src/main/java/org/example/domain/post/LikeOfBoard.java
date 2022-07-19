package org.example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "LikeOfBoard")
public class LikeOfBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likeIdx")
    private Long likeIdx;

    @Column(nullable = true)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardIdx")
    private Board boardIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User userIdx;

    @Builder
    public LikeOfBoard(Long idx, String type, Board boardIdx, User userIdx){
        this.likeIdx = idx;
        this.type = type;
        this.boardIdx = boardIdx;
        this.userIdx = userIdx;
    }
}
