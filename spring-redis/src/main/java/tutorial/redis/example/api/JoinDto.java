package tutorial.redis.example.api;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class JoinDto {

    private String email;
    private String password;
    private String nickname;
}
