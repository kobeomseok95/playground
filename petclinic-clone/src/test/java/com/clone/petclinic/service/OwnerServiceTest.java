package com.clone.petclinic.service;

import com.clone.petclinic.controller.dto.*;
import com.clone.petclinic.domain.Owner;
import com.clone.petclinic.domain.Pet;
import com.clone.petclinic.domain.PetType;
import com.clone.petclinic.domain.Visit;
import com.clone.petclinic.domain.base.Address;
import com.clone.petclinic.repository.OwnerRepository;
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
class OwnerServiceTest {

    @InjectMocks
    OwnerServiceImpl ownerService;

    @Mock
    OwnerRepository ownerRepository;

    Owner owner;
    Owner owner2;
    Owner owner3;

    @BeforeEach
    void setup() throws Exception {
        owner = Owner.builder()
                .id(3L)
                .firstName("test")
                .lastName("test")
                .phone("test")
                .address(Address.builder()
                        .city("test")
                        .street("test")
                        .zipcode("test")
                        .build())
                .pets(getPets())
                .build();
        owner2 = Owner.builder()
                .id(4L)
                .firstName("test")
                .lastName("test2")
                .phone("test")
                .address(Address.builder()
                        .city("test")
                        .street("test")
                        .zipcode("test")
                        .build())
                .pets(getPets())
                .build();
        owner3 = Owner.builder()
                .id(5L)
                .firstName("test")
                .lastName("last")
                .phone("test")
                .address(Address.builder()
                        .city("test")
                        .street("test")
                        .zipcode("test")
                        .build())
                .pets(getPets())
                .build();
    }

    @Test
    void owner_등록() throws Exception {

        //given
        OwnerJoinAndEditRequestDto requestDto = createOwnerJoinRequestDto();
        when(ownerRepository.save(any(Owner.class)))
                .thenReturn(owner);

        //when
        Long join = ownerService.join(requestDto);

        //then
        verify(ownerRepository, atLeastOnce()).save(any(Owner.class));
        assertEquals(join, owner.getId());
    }

    @Test
    void owner_수정() throws Exception {

        //given
        OwnerJoinAndEditRequestDto dto = getOwnerEditRequestDto();
        when(ownerRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(owner));

        //when
        ownerService.edit(owner.getId(), dto);

        //then
        verify(ownerRepository).findById(any(Long.class));
        assertAll(
                () -> assertEquals(owner.getFirstName(), "edit"),
                () -> assertEquals(owner.getLastName(), "edit"),
                () -> assertEquals(owner.getPhone(), "edit"),
                () -> assertEquals(owner.getAddress().getCity(), "edit"),
                () -> assertEquals(owner.getAddress().getStreet(), "edit"),
                () -> assertEquals(owner.getAddress().getZipcode(), "edit")
        );
    }

    @Test
    void owner_단건_조회() throws Exception {
        
        //given
        when(ownerRepository.findByIdFetch(any(Long.class)))
                .thenReturn(Optional.of(owner));
        
        //when
        OwnerOneResponseDto one = ownerService.findOne(owner.getId());
        
        //then
        verify(ownerRepository, atLeastOnce()).findByIdFetch(any(Long.class));
        assertEquals(one.getPets().size(), 2);

        for (OwnerPetsResponseDto pet : one.getPets()) {
            assertEquals(pet.getVisits().size(), 2);
            for (PetsVisitResponseDto visit : pet.getVisits()) {
                assertNotNull(visit);
            }
        }
    }

    @Test
    void owner_다수_조회_성공() throws Exception{

        //given
        when(ownerRepository.findByLastName(any(String.class)))
                .thenReturn(Arrays.asList(owner, owner2, owner3));

        //when
        List<OwnerMultipleResponseDto> dtos = ownerService.findByLastName("test");

        //then
        verify(ownerRepository, atLeastOnce()).findByLastName(any(String.class));
        assertEquals(dtos.size(), 3);
        for (OwnerMultipleResponseDto dto : dtos) {
            assertNotNull(dto);
            assertEquals(dto.getPetNames().size(), 2);
        }
    }

    @Test
    void owner_다수_조회_아무도_없을_경우() throws Exception{

        //given
        when(ownerRepository.findByLastName(any(String.class)))
                .thenReturn(Collections.emptyList());

        //when
        List<OwnerMultipleResponseDto> dtos = ownerService.findByLastName("test");

        //then
        verify(ownerRepository, atLeastOnce()).findByLastName(any(String.class));
        assertEquals(dtos.size(), 0);
    }

    private OwnerJoinAndEditRequestDto createOwnerJoinRequestDto() {
        return OwnerJoinAndEditRequestDto.builder()
                .firstName("test")
                .lastName("test")
                .phone("1234")
                .city("test")
                .street("test")
                .zipcode("test")
                .build();
    }

    private OwnerJoinAndEditRequestDto getOwnerEditRequestDto() {
        return OwnerJoinAndEditRequestDto.builder()
                .id(3L)
                .firstName("edit")
                .lastName("edit")
                .city("edit")
                .street("edit")
                .zipcode("edit")
                .phone("edit")
                .build();
    }

    private Set<Pet> getPets() {
        Set<Pet> pets = new HashSet<>();
        for (int i = 1; i < 3; i++) {
            pets.add(createPet(i));
        }
        return pets;
    }

    private Pet createPet(int i){
        Pet pet = Pet.builder()
                .name("test")
                .date(LocalDate.now())
                .petType(
                        PetType.builder()
                                .name("lizard")
                                .build())
                .visits(getVisits())
                .build();
        ReflectionTestUtils.setField(pet, "id", Integer.toUnsignedLong(i));

        return pet;
    }

    private Set<Visit> getVisits() {
        Set<Visit> visits = new HashSet<>();
        for (int i = 1; i < 3; i++) {
            visits.add(createVisit(i));
        }
        return visits;
    }

    private Visit createVisit(int i) {
        Visit visit = Visit.builder()
                .description("test")
                .date(LocalDate.now())
                .build();

        ReflectionTestUtils.setField(visit, "id", Integer.toUnsignedLong(i));
        return visit;
    }
}