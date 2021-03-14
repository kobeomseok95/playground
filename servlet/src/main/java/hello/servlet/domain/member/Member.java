package hello.servlet.domain.member;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    private Long id;
    private String username;
    private int age;

}
