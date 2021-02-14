package com.clone.petclinic.service;

import com.clone.petclinic.controller.dto.*;
import com.clone.petclinic.domain.Owner;
import com.clone.petclinic.domain.Pet;
import com.clone.petclinic.domain.PetType;
import com.clone.petclinic.domain.Visit;
import com.clone.petclinic.domain.base.Address;
import com.clone.petclinic.repository.OwnerRepository;
import com.clone.petclinic.repository.PetRepository;
import com.clone.petclinic.repository.VisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitServiceTest {

    @Mock
    PetRepository petRepository;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitServiceImpl visitService;

    Owner owner;
    Pet pet;
    PetType type;

    @BeforeEach
    void setUp() throws Exception {
        type = PetType.builder()
                .id(3L)
                .name("snake")
                .build();

        pet = Pet.builder()
                .id(2L)
                .name("pet1")
                .date(LocalDate.now())
                .visits(new HashSet<>())
                .petType(type)
                .build();

        owner = Owner.builder()
                .id(1L)
                .firstName("test")
                .lastName("test")
                .phone("01012341234")
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
    void 방문날짜_addview() throws Exception {

        //given
        when(petRepository.findByPetIdWithOwner(any(Long.class)))
                .thenReturn(Optional.of(pet));

        //when
        VisitResponseDto visitResponseDto = visitService.addVisitView(pet.getId());

        //then
        verify(petRepository).findByPetIdWithOwner(any(Long.class));
        assertAll(
                () -> assertEquals(visitResponseDto.getOwnerId(), pet.getOwner().getId().toString()),
                () -> assertEquals(visitResponseDto.getOwnerName(), pet.getOwner().getFirstName() + " " + pet.getOwner().getLastName()),
                () -> assertEquals(visitResponseDto.getPetId(), pet.getId().toString()),
                () -> assertEquals(visitResponseDto.getPetBirth(), pet.getDate().toString()),
                () -> assertEquals(visitResponseDto.getPetName(), pet.getName()),
                () -> assertEquals(visitResponseDto.getPetType(), pet.getPetType().getName()),
                () -> assertEquals(visitResponseDto.getVisits().size(), 0)
        );
    }

    @Test
    void 방문일정생성() throws Exception{

        //given
        AddVisitRequestDto requestDto = requestAddVisitDto();
        when(petRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(pet));

        //when
        visitService.addVisit(owner.getId(), pet.getId(), requestDto);

        //then
        verify(petRepository).findById(any(Long.class));
        verify(visitRepository).save(any(Visit.class));
    }

    private AddVisitRequestDto requestAddVisitDto() {
        return AddVisitRequestDto.builder()
                .date(LocalDate.now().toString())
                .description("test")
                .build();
    }
}
















