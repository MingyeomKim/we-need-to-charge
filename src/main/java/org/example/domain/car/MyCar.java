package org.example.domain.car;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.user.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class MyCar {
    @Id @GeneratedValue
    private Long id;

    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

}
