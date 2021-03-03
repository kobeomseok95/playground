package com.miniproject.yeolgongdabang.user;

import com.miniproject.yeolgongdabang.locker.Locker;
import com.miniproject.yeolgongdabang.seat.Seat;
import com.miniproject.yeolgongdabang.ticket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "user")
    private List<UserSeat> userSeats;  //일대다 다대일로 풀기

    @OneToMany(mappedBy = "user")
    private List<UserTicket> userTickets = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserLocker> lockers = new ArrayList<>();
}
