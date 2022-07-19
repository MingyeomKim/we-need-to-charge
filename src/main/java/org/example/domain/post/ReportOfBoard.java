package org.example.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.user.User;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "REPORTOFBOARD")
public class ReportOfBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportIdx")
    private Long reportIdx;

    @Column(nullable = false)
    private Long code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardIdx")
    private Board boardIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userIdx")
    private User userIdx;

    @Builder
    public ReportOfBoard(Long idx, Long code, User userIdx, Board boardIdx){
        this.reportIdx = idx;
        this.code = code;
        this.userIdx = userIdx;
        this.boardIdx = boardIdx;
    }
}
