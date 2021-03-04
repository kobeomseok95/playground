package com.miniproject.yeolgongdabang.user.repository;

import com.miniproject.yeolgongdabang.seat.Seat;
import com.miniproject.yeolgongdabang.user.User;
import com.miniproject.yeolgongdabang.user.UserSeat;
import org.h2.engine.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void init() {
//        User userNoSeat = User.builder()
//                .id(1L)
//                .phone("12341234")
//                .build();
//        User sitUser = User.builder()
//                .id(2L)
//                .phone("12312312")
//                .build();
//
//        Seat seat = Seat.builder()
//                .id(1L)
//                .seatNumber(30)
//                .empty(true)
//                .build();
//
//        UserSeat userSeat = UserSeat.builder()
//                .id(1L)
//                .seat(seat)
//                .user(sitUser)
//                .seated(true)
//                .build();

    }
}