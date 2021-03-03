package com.miniproject.yeolgongdabang.user;

import com.miniproject.yeolgongdabang.seat.Seat;
import com.miniproject.yeolgongdabang.ticket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private String phone;

    @OneToOne(mappedBy = "user")
    private Seat seat;

    @OneToMany(mappedBy = "user")
    private List<UserTicket> userTickets;
}
