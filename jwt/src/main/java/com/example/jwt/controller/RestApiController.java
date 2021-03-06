package com.example.jwt.controller;

import com.example.jwt.config.auth.PrincipalDetails;
import com.example.jwt.model.User;
import com.example.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RestApiController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String home() {
        return "<h1>home</h1>";
    }

    @PostMapping("/token")
    public String token() {
        return "<h1>token</h1>";
    }

    @PostMapping("/join")
    public String join(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        userRepository.save(user);
        return "회원가입 완료";
    }

    @GetMapping("api/v1/user")
    public String user(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("===============컨트롤러 " + principal.getUsername());
        return "user";
    }

    @GetMapping("api/v1/manager")
    public String manager() {
        return "manager";
    }

    @GetMapping("api/v1/admin")
    public String admin() {
        return "admin";
    }
}
