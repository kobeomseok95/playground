package com.miniproject.yeolgongdabang.user;

import com.miniproject.yeolgongdabang.seat.Seat;
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
public class UserSeat {

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

    @Column(nullable = false)
    private boolean seated;

    private Long remainSecond;

//    연관관계 편의 메서드
    public static UserSeat takeASeat(User user, Seat seat, Long ticketSecond) {
        UserSeat userSeat = UserSeat.builder()
                .user(user)
                .seat(seat)
                .seated(true)
                .remainSecond(ticketSecond)
                .build();

        changeUserAndSeat(user, userSeat, seat);
        return userSeat;
    }

    private static void changeUserAndSeat(User user, UserSeat userSeat, Seat seat) {
        user.getUserSeats().add(userSeat);
        seat.changeToNotEmpty(userSeat);
    }
}
