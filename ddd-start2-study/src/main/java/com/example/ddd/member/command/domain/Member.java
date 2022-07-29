package com.example.ddd.member.command.domain;

import com.example.ddd.common.event.Events;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String memberName;

    private String phone;

    public void changeInfo(String memberName, String phone) {
        this.memberName = memberName;
        this.phone = phone;
        Events.raise(new MemberInfoChangedEvent(id, memberName, phone));
    }
}
