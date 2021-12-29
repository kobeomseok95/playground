package com.example.solid.modules.unit.seat;

public class MockSeat {

    public static Seat of() {
        return Seat.builder()
                .id(1L)
                .seatNumber(20)
                .build();
    }
}
