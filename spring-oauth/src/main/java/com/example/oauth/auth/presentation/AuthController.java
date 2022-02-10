package com.example.oauth.auth.presentation;

import com.example.oauth.auth.domain.SocialLoginProvider;
import com.example.oauth.auth.dto.response.AuthResponse;
import com.example.oauth.auth.service.AuthService;
import com.example.oauth.member.domain.Member;
import com.example.oauth.member.util.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login/oauth2/{provider}")
    public ResponseEntity<AuthResponse> login(@PathVariable("provider") SocialLoginProvider provider,
                                              @RequestParam String code) {
        return ResponseEntity.ok(authService.login(provider, code));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader(value = "Authorization") String accessToken,
                                       @RequestHeader(value = "refreshToken") String refreshToken) {
        authService.logout(accessToken, refreshToken);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reissue")
    public ResponseEntity<AuthResponse> reissue(@AuthUser Member member) {
        return ResponseEntity.ok(authService.reissue(member));
    }
}
