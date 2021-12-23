package com.example.solid.modules.locker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class UsingLocker {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "USING_LOCKER_ID")
    private Long id;

    @OneToOne(fetch = LAZY) @JoinColumn(name = "LOCKER_ID", nullable = false)
    private Locker locker;

    @Column(nullable = false, unique = true)
    private String phone;
}
