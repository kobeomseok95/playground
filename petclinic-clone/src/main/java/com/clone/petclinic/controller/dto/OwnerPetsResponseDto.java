package com.clone.petclinic.controller.dto;

import com.clone.petclinic.domain.Pet;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerPetsResponseDto {
    private String id;
    private String name;
    private String birth;
    private String type;
    private List<PetsVisitResponseDto> visits;

    public OwnerPetsResponseDto(Pet pet){
        id = pet.getId().toString();
        name = pet.getName();
        birth = pet.getDate().toString();
        type = pet.getPetType().getName();
        visits = pet.getVisits().stream()
                .map(PetsVisitResponseDto::new)
                .collect(Collectors.toList());
    }
}
