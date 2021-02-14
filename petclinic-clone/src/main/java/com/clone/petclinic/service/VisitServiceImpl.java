package com.clone.petclinic.service;

import com.clone.petclinic.controller.dto.AddVisitRequestDto;
import com.clone.petclinic.controller.dto.OwnerOneResponseDto;
import com.clone.petclinic.controller.dto.VisitResponseDto;
import com.clone.petclinic.domain.Owner;
import com.clone.petclinic.domain.Pet;
import com.clone.petclinic.domain.Visit;
import com.clone.petclinic.repository.OwnerRepository;
import com.clone.petclinic.repository.PetRepository;
import com.clone.petclinic.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final VisitRepository visitRepository;

    @Transactional(readOnly = true)
    public VisitResponseDto addVisitView(Long petId){
        Pet findPet = petRepository.findByPetIdWithOwner(petId).orElseThrow();
        return new VisitResponseDto(findPet);
    }

    public void addVisit(Long ownerId, Long petId, AddVisitRequestDto request){
        Visit visit = new Visit();

        Pet pet = petRepository.findById(petId).orElseThrow();
        visit.convertDtoIntoVisit(request, pet);
        visitRepository.save(visit);
    }
}
