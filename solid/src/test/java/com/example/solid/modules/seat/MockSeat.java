package com.example.solid.modules.seat;

public class MockSeat {

    public static Seat of() {
        return Seat.builder()
                .id(1L)
                .seatNumber(20)
                .build();
    }
}
