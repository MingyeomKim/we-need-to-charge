package org.example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String join_status;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private String status;

    @Builder
    public User(Long user_id, String name, String nickname, String phone_number,
                String join_status, LocalDateTime created_at, String status) {
        this.user_id = user_id;
        this.name = name;
        this.nickname = nickname;
        this.phone_number = phone_number;
        this.join_status = join_status;
        this.created_at = created_at;
        this.status = status;
    }
}
