package org.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class MyCar {
    @Id @GeneratedValue
    @Column(name = "comment_idx")
    private Long id;

    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

}
