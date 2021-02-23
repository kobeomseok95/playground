package com.example.security.config.auth;

import com.example.security.user.User;
import com.example.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 시큐리티 설정에서 loginProcessingUrl("/login")으로 설정해두었다.
 * /login 요청이 오면 스프링이 UserDetailsService 타입으로 IoC되어있는
 * loadUserByUsername이 호출된다. 즉, /login 요청시 UserDetailsService 타입을 찾음
 * <p>
 * 이때 로그인 폼의 input name 속성을 name = "username"
 * name = "password"로 해야한다.(디폴트 및 권장)
 */
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * 시큐리티 session => Authentication => UserDetails 타입
     *
     * @param username
     * @return
     * 시큐리티 세션 내부 = Authentication
     * Authentication 내부 = PrincipalDetails(UserDetails타입)
     * 시큐리티 세션에 user를 넣어준다!
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return new PrincipalDetails(user);  //Authentication 객체 안에 들어간다.
        }
        return null;
    }
}
