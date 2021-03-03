package com.miniproject.yeolgongdabang.locker;

import com.miniproject.yeolgongdabang.user.User;
import com.miniproject.yeolgongdabang.user.UserLocker;
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
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locker_id")
    private Long id;

    @Column(nullable = false)
    private int lockerNumber;

    @OneToOne(mappedBy = "locker")
    private UserLocker userLocker;
}
