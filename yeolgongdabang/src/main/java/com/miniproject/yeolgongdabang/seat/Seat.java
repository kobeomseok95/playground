package com.miniproject.yeolgongdabang.seat;

import com.miniproject.yeolgongdabang.user.User;
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
public class Seat {

    @Id
    @GeneratedValue
    @Column(name = "seat_id")
    private Long id;

    @Column(nullable = false)
    private int seatNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private boolean empty;

    public void sitUser(User user) {
        if (this.user != null) {
            throw new IllegalStateException("이미 앉은 사람이 있습니다.");
        }
        this.user = user;
    }
}
