package com.miniproject.yeolgongdabang.user;

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
    private final List<SeatedUser> seatedUser = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private final List<TicketPurchasedUser> haveUserTickets = new ArrayList<>();

    @Column(nullable = false)
    private boolean hasTicket;

    @Column(nullable = false)
    private boolean seated;

    @OneToMany(mappedBy = "user")
    private final List<UserLocker> lockers = new ArrayList<>();

//    연관관계 편의 메서드
    public void addTicket(TicketPurchasedUser ticketPurchasedUser) {
        haveUserTickets.add(ticketPurchasedUser);
        hasTicket = true;
    }

    public void changeSeated(SeatedUser seatedUser) {
        if (seated) {
            throw new IllegalStateException("이미 앉아있는 사용자입니다.");
        }
        this.seatedUser.add(seatedUser);
        this.seated = true;
    }
}
