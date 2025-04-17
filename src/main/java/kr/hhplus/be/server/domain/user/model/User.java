package kr.hhplus.be.server.domain.user.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {

    private Long id;

    private String name;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public User(long userId) {
        this.id = userId;
    }

    public User() {

    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
