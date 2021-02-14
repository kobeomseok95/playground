package com.clone.petclinic.domain;

import com.clone.petclinic.controller.dto.AddVisitRequestDto;
import com.clone.petclinic.controller.dto.VisitResponseDto;
import com.clone.petclinic.domain.base.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Visit extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private String description;

    @Builder
    public Visit(LocalDate date, Long id, Pet pet, String description) {
        super(date);
        this.id = id;
        this.pet = pet;
        this.description = description;
    }

    //====연관관계 편의 메서드====
    public void addPet(Pet pet) {
        if (this.pet != null) {
            throw new IllegalArgumentException("이미 등록된 펫이 있습니다.");
        }
        this.pet = pet;
        pet.getVisits().add(this);
    }

    public void convertDtoIntoVisit(AddVisitRequestDto request, Pet pet) {
        this.description = request.getDescription();
        this.date = LocalDate.parse(request.getDate());
        addPet(pet);
    }
}
