package kr.hhplus.be.server.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class User {

    @Id
    private Long id;

    private String name;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public User(long userId) {
        this.id = userId;
    }

    public User() {

    }
}
