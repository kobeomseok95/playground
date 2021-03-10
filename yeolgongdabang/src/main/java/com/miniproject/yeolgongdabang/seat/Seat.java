package com.miniproject.yeolgongdabang.seat;

import com.miniproject.yeolgongdabang.user.SeatedUser;
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

    @Column(nullable = false, unique = true)
    private int seatNumber;

    @Column(nullable = false)
    private boolean empty;

    @Column(length = 100)
    private String shortDescription;

    @OneToOne(mappedBy = "seat")
    private SeatedUser seatedUser;

    public void changeToNotEmpty(SeatedUser userSeat) {
        if (this.seatedUser != null) {
            throw new IllegalStateException("이미 착석한 자리입니다.");
        }
        this.seatedUser = userSeat;
        this.empty = false;
    }

    public void changeToEmpty() {
        if (this.seatedUser == null) {
            throw new IllegalStateException("이미 비어있는 자리입니다.");
        }
        this.seatedUser = null;
        this.empty = true;
    }

//    연관관계 편의 메서드
    public void addSeatedUser(SeatedUser seatedUser) {
        this.empty = false;
        this.seatedUser = seatedUser;
    }
}
