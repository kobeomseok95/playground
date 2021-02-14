package com.clone.petclinic.domain;

import com.clone.petclinic.controller.dto.PetJoinAndEditRequestDto;
import com.clone.petclinic.domain.base.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Pet extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)  //Cascade?
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pettype_id")
    private PetType petType;

    @OneToMany(mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    @Builder
    public Pet(Long id, LocalDate date, String name, Owner owner, PetType petType, Set<Visit> visits) {
        super(date);
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.petType = petType;
        this.visits = visits;
    }

    //====생성 편의====
    public Pet(Owner owner, PetType type, PetJoinAndEditRequestDto dto) {
        addOwner(owner);
        this.petType = type;
        this.name = dto.getPetName();
        this.date = LocalDate.parse(dto.getPetBirth());
    }

    //====연관관계 편의 메서드====
    public void addOwner(Owner owner) {
        if (this.owner != null) {
            throw new IllegalStateException("이미 주인이 있습니다.");
        }
        this.owner = owner;
        owner.addPets(this);
    }

    public void convertDtoIntoPet(PetJoinAndEditRequestDto dto, PetType type){
        super.editBirth(dto.getPetBirth());
        this.name = dto.getPetName();
        this.petType = type;
    }
}
