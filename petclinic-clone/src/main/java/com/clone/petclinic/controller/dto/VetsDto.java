package com.clone.petclinic.controller.dto;

import com.clone.petclinic.domain.Speciality;
import com.clone.petclinic.domain.Vet;
import com.clone.petclinic.domain.VetSpeciality;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class VetsDto {

    private String name;
    private List<String> specialities;

    public VetsDto(Vet vet) {
        name = vet.getName();
        this.specialities = vet.getSpecialities().stream()
                .map(VetSpeciality::getSpeciality)
                .collect(Collectors.toList()).stream()
                .map(Speciality::getSubject)
                .collect(Collectors.toList());
    }
}
