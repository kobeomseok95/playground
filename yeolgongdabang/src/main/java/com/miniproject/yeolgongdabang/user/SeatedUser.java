package com.miniproject.yeolgongdabang.user;

import com.miniproject.yeolgongdabang.seat.Seat;
import com.miniproject.yeolgongdabang.ticket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    private LocalDateTime endDate;

    public static SeatedUser createSeatedUser(User user, Seat seat, LocalDateTime endDate) {

        SeatedUser seatedUser = SeatedUser.builder()
                .user(user)
                .seat(seat)
                .endDate(endDate)
                .build();

//        연관관계 편의 메서드
        seat.addSeatedUser(seatedUser);
        user.changeSeated(seatedUser);

        return seatedUser;
    }
}
