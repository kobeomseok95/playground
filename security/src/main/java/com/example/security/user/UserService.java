package com.example.security.user;

import com.example.security.user.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@RequiredArgsConstructor
//@Service
//@Transactional
public class UserService {

//    private final UserRepository userRepository;
//    private final ModelMapper modelMapper;
//
//    public Long save(UserInfoDto request) {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        request.setPassword(passwordEncoder.encode(request.getPassword()));
//
//        return userRepository.save(modelMapper.map(request, NotUseUserInfo.class)).getCode();
//    }
//
//    /**
//     * 시큐리티 필수 메서드 구현
//     * @param email (id)
//     * @return UserDetails UserInfo가 다운캐스팅!
//     * @throws UsernameNotFoundException 유저가 없을 경우 예외
//     */
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return userRepository.findByEmail(email)
//                .orElseThrow(
//                        () -> new UsernameNotFoundException(email + "의 회원을 찾을 수 없습니다.")
//                );
//    }
}
