package com.miniproject.yeolgongdabang.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

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

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
}
