package com.clone.petclinic.controller.dto;

import com.clone.petclinic.domain.Pet;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PetJoinAndEditRequestDto {

    @NotNull
    private String ownerId;

    @NotNull
    private String ownerName;
    private String petId;

    @NotBlank
    private String petName;

    @Pattern(regexp = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$")
    private String petBirth;

    @NotNull
    private String petType;

    public void convertPetIntoDto(Pet pet){
        this.ownerId = pet.getOwner().getId().toString();
        this.ownerName = pet.getOwner().getFirstName() + " " + pet.getOwner().getLastName();
        this.petId = pet.getId().toString();
        this.petName = pet.getName();
        this.petBirth = pet.getDate().toString();
        this.petType = pet.getPetType().getName();
    }
}
