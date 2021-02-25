package com.example.security.config.auth;

import com.example.security.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * 시큐리티가 /login 주소 요청을 낚아채서 로그인 진행
 * 로그인 진행이 완료되면 session을 만들어준다.(시큐리티 자신만의 세션공간
 * SecurityContextHolder에 세션 저장 (여기에는 Authentication 타입의 객체만 들어간다.)
 * <p>
 * Authentication안에 User정보가 있어야 된다.
 * User오브젝트의 타입은 UserDetails 타입 객체여야 한다.
 * <p>
 * 정리!
 * 시큐리티 세션영역에 들어갈 수 있는 객체는 Authentication타입
 * Authentication타입 안에는 UserDetails 타입의 User여야 한다.
 *
 * PrincipalDetails 는 UserDetails를 구현해서 Authentication에 들어갈 수 있다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalDetails implements UserDetails, OAuth2User {

    private User user;  //Composition
    private Map<String, Object> attributes;

    public PrincipalDetails(User user) {
        this.user = user;
    }

//    public PrincipalDetails(User user, Map<String, Object> attributes) {
//        this.user = user;
//        this.attributes = attributes;
//    }

    /**
     * 해당 유저의 권한을 리턴하는 곳!
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
