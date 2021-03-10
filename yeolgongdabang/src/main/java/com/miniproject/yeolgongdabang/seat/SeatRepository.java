package com.miniproject.yeolgongdabang.seat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    Seat findBySeatNumber(int seatNumber);
}
