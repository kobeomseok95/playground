package tutorial.redis.example.domain.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class JoinDto {

    private String email;
    private String password;
    private String nickname;
}
