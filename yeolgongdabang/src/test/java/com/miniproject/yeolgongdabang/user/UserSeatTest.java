package com.miniproject.yeolgongdabang.user;

import com.miniproject.yeolgongdabang.seat.Seat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class UserSeatTest {

    User user1;
    User user2;
    Seat seat;

    @BeforeEach
    void init() {
        user1 = User.builder()
                .id(1L)
                .phone("12341234")
                .build();

        user2 = User.builder()
                .id(2L)
                .phone("56785678")
                .build();

        seat = Seat.builder()
                .id(30L)
                .seatNumber(30)
                .empty(true)
                .build();
    }

    @Test
    void 좌석_착석_테스트 () throws Exception {

//        //given & when
//        UserSeat userSeat = UserSeat.takeASeat(user1, seat);
//
//        //then
//        assertAll(
//                () -> assertEquals(user1.getUserSeats().size(), 1),
//                () -> assertTrue(user1.getUserSeats().contains(userSeat)),
//                () -> assertEquals(seat.getUserSeat().getUser(), user1),
//                () -> assertFalse(seat.isEmpty()),
//                () -> assertTrue(userSeat.isSeated())
//        );
    }

    @Test
    void 좌석_착석_테스트_이미_앉아있는_좌석일_경우 () throws Exception {

        // given
//        UserSeat userSeat = UserSeat.takeASeat(user1, seat);
//
//        // when & then
//        assertThrows(IllegalStateException.class, () -> UserSeat.takeASeat(user2, seat));
    }

    @Test
    void 시간_연산_테스트1 () throws Exception {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime one = now.plusHours(1L);
        assertEquals(ChronoUnit.SECONDS.between(now, one), 3600L);
    }

    @Test
    void 시간_연산_테스트2_1시간_사용권 () throws Exception {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.plusSeconds(3600L);
        System.out.println("now = " + now);
        System.out.println("expired = " + expired);
        assertEquals(ChronoUnit.SECONDS.between(now, expired), 3600L);
    }
}