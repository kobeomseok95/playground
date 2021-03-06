package com.example.jwt.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jwt.config.auth.PrincipalDetails;
import com.example.jwt.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 스프링 시큐리티에서 UsernamePasswordAuthenticationFilter가 있음
 * 동작할 때 : /login 요청후 username, password를 post로 전송하면
 * 이 필터가 동작한다.
 *
 * formLogin()을 disable해서 동작하지 않기 때문에 시큐리티 필터에 이 필터를 등록하기
 */
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    /**
     * /login 요청시 login 시도를 위해 실행되는 메서드
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        /**
         * username, password 받아서
         * 정상인지 로그인 시도하기
         * AuthenticationManager로 로그인 시도를 하면
         * PrincipalDetailsService의 loadUserByUsername 메서드 호출 호출된다.
         *
         * PrincipalDetails를 세션에 담고 > 이걸 세션에 담지 않으면 권한 관리가 안된다.
         *
         * JWT 토큰을 만들어서 응답해준다.
         */
        try {
//            BufferedReader br = request.getReader();
//
//            String input = null;
//            while ((input = br.readLine()) != null) {
//                System.out.println(input);
//            }
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(request.getInputStream(), User.class);

//            토큰 생성 및 db에 회원 조회
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

//            PrincipalDetailsService.loadUserbyUsername() 실행
//            인증이 정상적으로 되었음
            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);
//
//            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
//            System.out.println("로그인 완료, 아이디 : " + principalDetails.getUser().getUsername());


//            리턴될때 세션에 authentication 객체가 저장된다.
//            로그인이 정상적으로 되었다.
//            세션에 왜 저장? 권한 관리를 위해!
            return authentication;
            /**
             * JWT 토큰방식을 이용하면 굳이 세션을 만들 이유가 없다. 하지만 왜 세션을 만들었냐?
             * 권한관리를 시큐리티에게 알아서 하게끔 한 것.
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * attemptAuthentication 실행후 인증이 정상적으로 되었으면
     * successfulAuthentication이 실행된다.
     *
     * 여기서 JWT 토큰을 만들어 request 요청한 사용자에게 JWT 토큰을 응답해주면 된다.
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

        String jwtToken = JWT.create()
                .withSubject("범석토큰")    //토큰 이름, 의미없음
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * 60 * 10))) //10분 유효시간
                .withClaim("id", principalDetails.getUser().getId())
                .withClaim("username", principalDetails.getUser().getUsername())
                .sign(Algorithm.HMAC512("범석")); // 서버만 알고 있는 시크릿 값을 알고 있어야 한다.


        response.addHeader("Authorization", "Bearer " + jwtToken);
        /**
         * 기존의 로그인 방식
         *
         * username, password 로그인
         * 서버쪽 세션ID 생성
         * 클라이언트의 쿠키에 세션ID 응답
         *
         * 요청할 때 마다 쿠키의 세션ID를 들고 서버에 요청하면 서버가 유효한 세션ID
         * 인지 판단해서 유효하면 인증이 필요한 페이지로 접근한다. 이때 시큐리티가
         * 클라이언트의 권한을 체크하여 응답해줌줌
         *
         * 지금 방식
         * username, password 로그인 정상
         * JWT 토큰 생성
         * 클라이언트 쪽으로 JWT토큰 응답
         *
         * 요청할 때 마다 JWT토큰을 들고 요청한다. 
         * 서버에서는 JWT토큰이 유효한지 판단한다. > 필터가 이 역할을 하고, 만들어야함
         * */
    }
}
