package com.example.solid.modules.seat;


import com.example.solid.modules.BaseEntity;
import com.example.solid.modules.voucher.MemberVoucher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class TakenSeat extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "TAKEN_SEAT_ID")
    private Long id;

    @ManyToOne(fetch = LAZY) @JoinColumn(name = "USING_VOUCHER_ID", nullable = false)
    private MemberVoucher memberVoucher;

    @OneToOne(fetch = LAZY) @JoinColumn(name = "SEAT_ID", nullable = false)
    private Seat seat;

    @Column(nullable = false)
    private boolean use;

    @Column(nullable = false)
    private LocalDateTime remainDateTime;
}
