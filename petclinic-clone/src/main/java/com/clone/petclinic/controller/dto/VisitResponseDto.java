package com.clone.petclinic.controller.dto;

import com.clone.petclinic.domain.Pet;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class VisitResponseDto {

    private String ownerId;
    private String ownerName;

    private String petId;
    private String petName;
    private String petBirth;
    private String petType;
    private String description;

    private List<PetsVisitResponseDto> visits;

    public VisitResponseDto(Pet pet) {
        ownerId = pet.getOwner().getId().toString();
        ownerName = pet.getOwner().getFirstName() + " " + pet.getOwner().getLastName();
        petId = pet.getId().toString();
        petName = pet.getName();
        petBirth = pet.getDate().toString();
        petType = pet.getPetType().getName();
        visits = pet.getVisits().stream()
                .map(PetsVisitResponseDto::new)
                .collect(Collectors.toList());
    }
}
