package com.jpa.cascadejoinexample.joinColumnEx;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class OneClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ONE_ID")
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "oneClass")
//    private List<ManyClass> many = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private OneClass parent;

    @OneToMany(mappedBy = "parent")
    private List<OneClass> children = new ArrayList<>();
}
