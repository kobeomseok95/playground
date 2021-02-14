package com.clone.petclinic.service;

import com.clone.petclinic.controller.dto.PetJoinAndEditRequestDto;
import com.clone.petclinic.domain.Owner;
import com.clone.petclinic.domain.Pet;
import com.clone.petclinic.domain.PetType;
import com.clone.petclinic.domain.base.Address;
import com.clone.petclinic.repository.OwnerRepository;
import com.clone.petclinic.repository.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @InjectMocks
    PetServiceImpl petService;

    Owner owner;
    PetType type;
    Pet pet;

    @BeforeEach
    void setUp() throws Exception{
        type = PetType.builder()
                .id(2L)
                .name("bird")
                .build();

        pet = Pet.builder()
                .id(3L)
                .name("test")
                .date(LocalDate.now())
                .petType(type)
                .visits(new HashSet<>())
                .build();

        owner = Owner.builder()
                .id(1L)
                .firstName("test")
                .lastName("test")
                .phone("test")
                .pets(new HashSet<>())
                .address(
                        Address.builder()
                                .city("test")
                                .street("test")
                                .zipcode("test")
                                .build()
                )
                .build();
        pet.addOwner(owner);
    }

    @Test
    void Pet_등록() throws Exception {

        //given
        PetJoinAndEditRequestDto requestDto = createPetJoinRequestDto(owner);
        when(ownerRepository.findByIdFetch(any(Long.class)))
                .thenReturn(Optional.of(owner));
        when(petRepository.findByPetTypeName(any(String.class)))
                .thenReturn(type);

        //when
        petService.addPet(owner.getId(), requestDto);

        //then
        assertEquals(owner.getPets().size(), 2);
    }

    @Test
    void pet_수정() throws Exception {

        //given
        PetJoinAndEditRequestDto requestDto = createPetEditRequestDto(owner);
        when(petRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(pet));
        when(petRepository.findByPetTypeName(any(String.class)))
                .thenReturn(PetType.builder()
                        .id(5L)
                        .name("bird")
                        .build());

        //when
        petService.editPet(owner.getId(), pet.getId(), requestDto);

        //then
        verify(petRepository).findById(any(Long.class));
        verify(petRepository).findByPetTypeName(any(String.class));
        Set<Pet> pets = owner.getPets();
        assertAll(
                () -> assertEquals(owner.getPets().size(), 1),
                () -> assertEquals(pets.iterator().next().getPetType().getName(), "bird"),
                () -> assertEquals(pets.iterator().next().getName(), "editPet")
        );
    }

    private PetJoinAndEditRequestDto createPetEditRequestDto(Owner owner){
        return PetJoinAndEditRequestDto.builder()
                .ownerId(owner.getId().toString())
                .ownerName(owner.getFirstName() + " " + owner.getLastName())
                .petBirth(LocalDate.now().toString())
                .petName("editPet")
                .petType("bird")
                .build();
    }

    private PetJoinAndEditRequestDto createPetJoinRequestDto(Owner owner) {
        return PetJoinAndEditRequestDto.builder()
                .ownerId(owner.getId().toString())
                .ownerName(owner.getFirstName() + " " + owner.getLastName())
                .petBirth(LocalDate.now().toString())
                .petName("pettest")
                .petType("snake")
                .build();
    }
}