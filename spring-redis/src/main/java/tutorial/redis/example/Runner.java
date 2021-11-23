package tutorial.redis.example;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tutorial.redis.example.domain.dto.JoinDto;
import tutorial.redis.example.service.MemberService;

@Component
@RequiredArgsConstructor
@Transactional
public class Runner implements CommandLineRunner {

    private final MemberService memberService;

    @Override
    public void run(String... args) throws Exception {
        JoinDto testJoin = JoinDto.builder()
                .email("test@test.com")
                .password("1234")
                .nickname("test")
                .build();
        memberService.join(testJoin);

        JoinDto adminJoin = JoinDto.builder()
                .email("admin@admin.com")
                .password("1234")
                .nickname("admin")
                .build();
        memberService.joinAdmin(adminJoin);
    }
}
