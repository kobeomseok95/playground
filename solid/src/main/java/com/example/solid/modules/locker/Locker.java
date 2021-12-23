package com.example.solid.modules.locker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class Locker {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "LOCKER_ID")
    private Long id;

    @Column(nullable = false)
    private int lockerNumber;
}
