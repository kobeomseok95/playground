package com.clone.petclinic.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class VetSpeciality {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vet_speciality_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    public void addVetAndSpeciality(Vet vet) {
        vet.getSpecialities().add(this);
    }
}
