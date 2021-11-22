package tutorial.redis.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import tutorial.redis.example.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    Optional<Member> findByUsername(String username);
}
