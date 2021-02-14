package com.clone.petclinic.controller;

import com.clone.petclinic.controller.dto.OwnerOneResponseDto;
import com.clone.petclinic.controller.dto.PetJoinAndEditRequestDto;
import com.clone.petclinic.service.OwnerService;
import com.clone.petclinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private final PetService petService;
    private final OwnerService ownerService;

    @PostMapping("/pets/new")
    public OwnerOneResponseDto addPet(@PathVariable("ownerId") @NotNull Long ownerId,
                                      @RequestBody @Valid PetJoinAndEditRequestDto request) {
        petService.addPet(ownerId, request);
        return ownerService.findOne(ownerId);
    }

    @PutMapping("/pets/{petId}/edit")
    public OwnerOneResponseDto editPet(@PathVariable("ownerId") @NotNull Long ownerId,
                                        @PathVariable("petId") @NotNull Long petId,
                                        @RequestBody @Valid PetJoinAndEditRequestDto request) {
        petService.editPet(ownerId, petId, request);
        return ownerService.findOne(ownerId);
    }
}
