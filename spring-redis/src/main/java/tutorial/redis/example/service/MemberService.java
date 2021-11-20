package tutorial.redis.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorial.redis.example.api.JoinDto;
import tutorial.redis.example.api.LoginDto;
import tutorial.redis.example.api.MemberInfo;
import tutorial.redis.example.api.TokenDto;
import tutorial.redis.example.config.redis.RefreshToken;
import tutorial.redis.example.domain.Member;
import tutorial.redis.example.repository.MemberRepository;
import tutorial.redis.example.repository.RefreshTokenRedisRepository;
import tutorial.redis.example.util.JwtTokenUtil;

import java.util.NoSuchElementException;

import static tutorial.redis.example.config.jwt.JwtExpirationEnums.REFRESH_TOKEN_EXPIRATION_TIME;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final RefreshTokenRedisRepository refreshTokenRedisRepository;
    private final JwtTokenUtil jwtTokenUtil;

    public void join(JoinDto joinDto) {
        joinDto.setPassword(passwordEncoder.encode(joinDto.getPassword()));
        memberRepository.save(Member.of(joinDto));
    }

    public TokenDto login(LoginDto loginDto) {
        Member member = memberRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new NoSuchElementException("회원이 없습니다."));
        checkPassword(loginDto.getPassword(), member.getPassword());

        String accessToken = jwtTokenUtil.generateToken(member);
        RefreshToken refreshToken = refreshTokenRedisRepository.save(RefreshToken.createRefreshToken(member.getUsername(),
                jwtTokenUtil.generateRefreshToken(member), REFRESH_TOKEN_EXPIRATION_TIME.getValue()));
        return TokenDto.of(accessToken, refreshToken.getRefreshToken());
    }

    private void checkPassword(String rawPassword, String findMemberPassword) {
        if (!passwordEncoder.matches(rawPassword, findMemberPassword)) {
            throw new IllegalArgumentException("비밀번호가 맞지 않습니다.");
        }
    }

    public MemberInfo getMemberInfo(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("회원이 없습니다."));
        return MemberInfo.builder()
                .username(member.getUsername())
                .email(member.getEmail())
                .build();
    }
}
