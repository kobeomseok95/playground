package com.miniproject.yeolgongdabang.user;

import com.miniproject.yeolgongdabang.ticket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketPurchasedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_ticket_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    private LocalDateTime payDate;

    private LocalDateTime endDate;

    private boolean nonExpired; //true 사용중, false 만료

    public static TicketPurchasedUser createTicketPurchasedUser(User user, Ticket ticket) {
        LocalDateTime payDate = LocalDateTime.now();
        LocalDateTime endDate = payDate.plusSeconds(ticket.getSecond());

        TicketPurchasedUser ticketPurchasedUser = TicketPurchasedUser.builder()
                .user(user)
                .ticket(ticket)
                .payDate(payDate)
                .endDate(endDate)
                .nonExpired(true)
                .build();

        // 연관관계 세팅
        user.addTicket(ticketPurchasedUser);

        return ticketPurchasedUser;
    }
}
