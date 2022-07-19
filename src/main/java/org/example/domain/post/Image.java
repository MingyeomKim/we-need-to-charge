package org.example.domain.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imageIdx")
    private Long imageIdx;

    @ManyToOne
    @JoinColumn(name = "boardIdx")
    private Board boardIdx;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Long imgNum; // new create!

    @Column(nullable = false)
    private Long priority;

    public Image(Long idx, Board boardIdx, String url, Long imgNum, Long priority){
        this.imageIdx = idx;
        this.boardIdx = boardIdx;
        this.imgNum = imgNum;
        this.priority = priority;
    }
}
