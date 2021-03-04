package com.miniproject.yeolgongdabang.user.service;

import com.miniproject.yeolgongdabang.user.User;
import com.miniproject.yeolgongdabang.user.UserSeat;
import com.miniproject.yeolgongdabang.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void join(String phone) {
        UserSeat userSeat = userRepository.findByPhoneFetchSeatedAndEnableSeat(phone);

        if (userSeat.getUser() == null) {
            log.info("===================유효한 회원이 아닙니다.===================");
        } else if (isEnableJoin(userSeat)) {
            log.info("===================출입문이 열립니다.===================");
        } else {
            log.info("===================좌석 선택하기===================");
        }
    }

    public boolean isEnableJoin(UserSeat userSeat) {
        return userSeat != null;
    }
}
