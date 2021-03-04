package com.miniproject.yeolgongdabang.user;

import com.miniproject.yeolgongdabang.seat.Seat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void 좌석_착석_테스트() throws Exception {

        //given
        UserSeat userSeat = UserSeat.builder()
                .id(1L)
                .user(user1)
                .seat(seat)
                .seated(true)
                .build();

        //when
        userSeat.takeASeat(user1, seat);

        //then
        assertAll(
                () -> assertEquals(user1.getUserSeats().size(), 1),
                () -> assertTrue(user1.getUserSeats().contains(userSeat)),
                () -> assertEquals(seat.getUser(), user1),
                () -> assertTrue(userSeat.isSeated())
        );
    }

    @Test
    void 좌석_착석_테스트_이미_앉아있는_좌석일_경우() throws Exception {

        // given
        UserSeat userSeat = UserSeat.builder()
                .id(1L)
                .user(user1)
                .seat(seat)
                .seated(true)
                .build();
        userSeat.takeASeat(user1, seat);

        // when
        UserSeat userSeat2 = UserSeat.builder()
                .id(2L)
                .user(user2)
                .seat(seat)
                .seated(true)
                .build();

        // then
        assertThrows(IllegalStateException.class, () -> userSeat.takeASeat(user2, seat));
    }
}