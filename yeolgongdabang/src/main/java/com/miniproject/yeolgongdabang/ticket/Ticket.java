package com.miniproject.yeolgongdabang.ticket;

import com.miniproject.yeolgongdabang.user.User;
import com.miniproject.yeolgongdabang.user.UserTicket;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
public abstract class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;

    @Column(nullable = false)
    private String ticketName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Long second;
}
