package com.miniproject.yeolgongdabang.user;

import com.miniproject.yeolgongdabang.seat.Seat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserSeatTest {

    User user;
    Seat seat;

    @BeforeEach
    void init() {
        user = User.builder()
                .id(1L)
                .phone("12341234")
                .build();

        seat = Seat.builder()
                .id(30L)
                .seatNumber(30)
                .empty(true)
                .build();
    }

    @Test
    void 좌석_착석_테스트() throws Exception {
        //given
        UserSeat userSeat = UserSeat.builder()
                .id(1L)
                .user(user)
                .seat(seat)
                .seated(true)
                .build();

        //when
        userSeat.takeASeat(user, seat);

        //then
        assertAll(
                () -> assertEquals(user.getUserSeats().size(), 1),
                () -> assertTrue(user.getUserSeats().contains(userSeat)),
                () -> assertEquals(seat.getUser(), user),
                () -> assertTrue(userSeat.isSeated())
        );
    }
}