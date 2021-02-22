package com.example.security.controller;

import com.example.security.user.User;
import com.example.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public @ResponseBody
    String user() {
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody
    String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody
    String manager() {
        return "manager";
    }

    //  SecurityConfig의 anyRequest.permitAll()에 의해
    //  시큐리티 필터가 낚지 않는다.
    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(User user) {
        user.setRole("ROLE_USER");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);  //단순히 save할 경우 시큐리티가 동작하지 않는다. 비밀번호를 암호화 하지 않았기 때문
        return "redirect:/loginForm";
    }

    @Secured("ROLE_ADMIN")  //특정 메서드의 권한을 부여하고 싶을 때 사용! 권한이 한가지 일 경우!
    @GetMapping("/info")
    public @ResponseBody String info() {
        return "개인 정보";
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')") //이 메서드가 실행되기 직전에 실행되는 어노테이션, 권한이 여러개 일 경우!
    @GetMapping("/data")
    public @ResponseBody String data() {
        return "데이터 정보";
    }
}
