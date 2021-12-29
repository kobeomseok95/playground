package com.example.solid.modules.unit.voucher.domain;


import com.example.solid.modules.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class MemberVoucher extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "MEMBER_VOUCHER_ID")
    private Long id;

    @OneToOne(fetch = LAZY) @JoinColumn(name = "VOUCHER_ID", nullable = false)
    private Voucher voucher;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private LocalDateTime expiredDateTime;

    @Column(nullable = false)
    private boolean use;

    public static MemberVoucher of(String phone, Voucher voucher) {
        return MemberVoucher.builder()
                .phone(phone)
                .voucher(voucher)
                .expiredDateTime(now().plusHours(voucher.getTime()))
                .use(true)
                .build();
    }
}
