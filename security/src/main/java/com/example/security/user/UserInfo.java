package com.example.security.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
public class UserInfo implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Long code;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "auth")
    private String auth;

    @Builder
    public UserInfo(String email, String password, String auth) {
        this.email = email;
        this.password = password;
        this.auth = auth;
    }

    /**
     *
     * @return 사용자의 권한을 컬렉션으로 반환
     * GrantedAuthority 구현해야함
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : auth.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    /**
     * @return 사용자의 아이디(이메일, unique) 반환
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * @return 계정 만료 여부 반환
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;    // 만료되지 않음
    }

    /**
     * @return 계정 잠금 여부 반환
     */
    @Override
    public boolean isAccountNonLocked() {
        return false;    // 안잠겼음
    }

    /**
     * @return 패스워드 만료 여부 반환
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;    // 만료 안됨
    }

    /**
     * @return 계정 사용여부
     */
    @Override
    public boolean isEnabled() {
        return true;    // 사용 가능
    }
}
