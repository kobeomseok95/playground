package tutorial.redis.example.domain;

import lombok.*;
import tutorial.redis.example.api.JoinDto;

import javax.persistence.*;

import java.util.UUID;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity @Getter @NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED) @Builder
public class Member {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "MEMBER_ID")
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true)
    private String nickname;

    public static Member of(JoinDto joinDto) {
        return Member.builder()
                .username(UUID.randomUUID().toString())
                .email(joinDto.getEmail())
                .password(joinDto.getPassword())
                .nickname(joinDto.getNickname())
                .build();
    }
}
