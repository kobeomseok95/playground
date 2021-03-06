package com.miniproject.yeolgongdabang.user;

import com.miniproject.yeolgongdabang.ticket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTicket {

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

    private boolean nonExpired; //true 사용중, false 만료

    private LocalDateTime payDate;

    private LocalDateTime endDate;

//    연관관계 편의 메서드
    public static UserTicket buyATicket(User user, Ticket ticket) {
        UserTicket userTicket = UserTicket.builder()
                .user(user)
                .ticket(ticket)
                .nonExpired(true)
                .payDate(LocalDateTime.now())
                .build();

        user.getUserTickets().add(userTicket);

        return userTicket;
    }
}
