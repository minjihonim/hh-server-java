package kr.hhplus.be.server.infrastructure.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    private Long id;

    private String name;

    private LocalDateTime registerDate;

    private LocalDateTime updateDate;

    public UserEntity(long userId) {
        this.id = userId;
    }
}
