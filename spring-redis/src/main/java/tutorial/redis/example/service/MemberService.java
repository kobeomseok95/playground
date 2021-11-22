package tutorial.redis.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorial.redis.example.domain.*;
import tutorial.redis.example.domain.dto.JoinDto;
import tutorial.redis.example.domain.dto.LoginDto;
import tutorial.redis.example.domain.dto.MemberInfo;
import tutorial.redis.example.domain.dto.TokenDto;
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
    private final LogoutAccessTokenRedisRepository logoutAccessTokenRedisRepository;
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

    public void logout(TokenDto tokenDto) {
        String accessToken = resolveToken(tokenDto.getAccessToken());
        long remainMilliSeconds = jwtTokenUtil.getRemainMilliSeconds(accessToken);
        String username = jwtTokenUtil.getUsername(accessToken);
        refreshTokenRedisRepository.deleteById(username);
        logoutAccessTokenRedisRepository.save(LogoutAccessToken.of(accessToken, username, remainMilliSeconds));
    }

    private String resolveToken(String token) {
        return token.substring(7);
    }
}
