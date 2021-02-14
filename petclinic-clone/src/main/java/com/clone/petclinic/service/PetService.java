package com.clone.petclinic.service;

import com.clone.petclinic.controller.dto.PetJoinAndEditRequestDto;

public interface PetService {

    void addPet(Long ownerId, PetJoinAndEditRequestDto dto);

    PetJoinAndEditRequestDto editPetView(Long id);

    void editPet(Long ownerId, Long petId, PetJoinAndEditRequestDto dto);
}
