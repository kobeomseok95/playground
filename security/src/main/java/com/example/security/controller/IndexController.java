package com.example.security.controller;

import com.example.security.user.User;
import com.example.security.user.UserRepository;
import com.example.security.user.dto.KakaoProfile;
import com.example.security.user.dto.OAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Slf4j
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
    public @ResponseBody
    String info() {
        return "개인 정보";
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')") //이 메서드가 실행되기 직전에 실행되는 어노테이션, 권한이 여러개 일 경우!
    @GetMapping("/data")
    public @ResponseBody
    String data() {
        return "데이터 정보";
    }

    @GetMapping("/auth/kakao/callback")
    public @ResponseBody String kakaoCallback(String code) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate(); // http 요청 라이브러리

        //헤더 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        //바디 생성
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "16844db3d0efb3fe18fdd1212b7fb6b3");
        params.add("redirect_uri", "http://localhost:8084/auth/kakao/callback");
        params.add("code", code);

        // 헤더 + 바디
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token", //요청주소
                HttpMethod.POST,    //요청 타입
                kakaoTokenRequest,  //보낼 데이터
                String.class        //응답 클래스
        );

        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oAuthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);

        System.out.println("카카오 액세스 토큰 = " + oAuthToken.getAccess_token());

        // access token으로 리소스 서버 접근하기
        RestTemplate restTemplateForAccess = new RestTemplate();

        // 바디가 없어도 되므로 헤더만 생성
        HttpHeaders httpHeadersForAccess = new HttpHeaders();
        httpHeadersForAccess.add("Authorization", "Bearer " + oAuthToken.getAccess_token());
        httpHeadersForAccess.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest =
                new HttpEntity<>(httpHeadersForAccess);

        ResponseEntity<String> kakaoProfileResponse = restTemplateForAccess.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        ObjectMapper objectMapperForKakaoProfile = new ObjectMapper();
        KakaoProfile kakaoProfile = objectMapperForKakaoProfile.readValue(kakaoProfileResponse.getBody(), KakaoProfile.class);

        System.out.println("카카오 id값 : " + kakaoProfile.getId());
        System.out.println("카카오 이메일 : " + kakaoProfile.getKakao_account().getEmail());

        return kakaoProfileResponse.getBody();
    }
}
