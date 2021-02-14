package com.clone.petclinic.controller;

import com.clone.petclinic.controller.dto.OwnerOneResponseDto;
import com.clone.petclinic.controller.dto.OwnerPetsResponseDto;
import com.clone.petclinic.controller.dto.PetJoinAndEditRequestDto;
import com.clone.petclinic.domain.Owner;
import com.clone.petclinic.domain.Pet;
import com.clone.petclinic.domain.PetType;
import com.clone.petclinic.domain.base.Address;
import com.clone.petclinic.service.OwnerService;
import com.clone.petclinic.service.PetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PetController.class)
class PetControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    OwnerService ownerService;

    @MockBean
    PetService petService;

    Owner owner;
    Pet pet;
    PetType type;

    @BeforeEach
    void setUp() throws Exception {
        type = PetType.builder()
                .id(1L)
                .name("snake")
                .build();

        owner = Owner.builder()
                .id(3L)
                .firstName("owner1")
                .lastName("owner1")
                .phone("1234")
                .pets(new HashSet<>())
                .address(
                        Address.builder()
                                .city("test")
                                .street("test")
                                .zipcode("test")
                                .build()
                )
                .build();

        pet = Pet.builder()
                .id(2L)
                .petType(type)
                .date(LocalDate.now())
                .name("pet1")
                .visits(new HashSet<>())
                .build();
        pet.addOwner(owner);
    }

    @Test
    void pet_등록() throws Exception {

        //given
        PetJoinAndEditRequestDto requestDto = createPetJoinRequestDto(owner);
        OwnerOneResponseDto responseDto = createPetJoinResponseDto(requestDto);
        when(ownerService.findOne(any(Long.class)))
                .thenReturn(responseDto);

        //when, then
        mockMvc.perform(post("/owners/{ownerId}/pets/new", owner.getId())
                        .content(objectMapper.writeValueAsString(requestDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is("3")))
                .andExpect(jsonPath("$.name", is("owner1 owner1")))
                .andExpect(jsonPath("$.phone", is("1234")))
                .andExpect(jsonPath("$.city", is("test")))
                .andExpect(jsonPath("$.street", is("test")))
                .andExpect(jsonPath("$.zipcode", is("test")))
                .andExpect(jsonPath("$.pets.length()", is(1)));
        verify(ownerService).findOne(any(Long.class));
    }

    @Test
    void pet_수정() throws Exception {

        //given
        PetJoinAndEditRequestDto requestDto = createPetEditRequestDto(owner, pet);
        OwnerOneResponseDto responseDto = createOwnerOneResponseDtoForPetEdit(requestDto);
        when(ownerService.findOne(any(Long.class)))
                .thenReturn(responseDto);

        //when, then
        mockMvc.perform(put("/owners/{ownerId}/pets/{petId}/edit",
                                owner.getId(), pet.getId())
                        .content(objectMapper.writeValueAsString(requestDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is("3")))
                .andExpect(jsonPath("$.name", is("owner1 owner1")))
                .andExpect(jsonPath("$.pets.length()", is(1)))
                .andExpect(jsonPath("$.pets[0].id", is("2")))
                .andExpect(jsonPath("$.pets[0].birth").exists())
                .andExpect(jsonPath("$.pets[0].name", is("edit")))
                .andExpect(jsonPath("$.pets[0].type", is("bird")))
                .andDo(print());
    }

    private OwnerOneResponseDto createOwnerOneResponseDtoForPetEdit(PetJoinAndEditRequestDto requestDto) {
        return OwnerOneResponseDto.builder()
                .id(requestDto.getOwnerId())
                .name(requestDto.getOwnerName())
                .pets(
                        Arrays.asList(
                                OwnerPetsResponseDto.builder()
                                        .id(requestDto.getPetId())
                                        .birth(requestDto.getPetBirth())
                                        .name(requestDto.getPetName())
                                        .type(requestDto.getPetType())
                                        .build()
                        )
                )
                .build();
    }

    private PetJoinAndEditRequestDto createPetEditRequestDto(Owner owner, Pet pet) {
        return PetJoinAndEditRequestDto.builder()
                .ownerId(owner.getId().toString())
                .ownerName(owner.getFirstName() + " " + owner.getLastName())
                .petId(pet.getId().toString())
                .petName("edit")
                .petType("bird")
                .petBirth(LocalDate.now().toString())
                .build();
    }

    private PetJoinAndEditRequestDto createPetJoinRequestDto(Owner owner) {
        return PetJoinAndEditRequestDto.builder()
                .ownerId(owner.getId().toString())
                .ownerName(owner.getFirstName() + " " + owner.getLastName())
                .petType("bird")
                .petName("add")
                .petBirth(LocalDate.now().toString())
                .build();
    }

    private OwnerOneResponseDto createPetJoinResponseDto(PetJoinAndEditRequestDto requestDto) {
        return OwnerOneResponseDto.builder()
                .id(owner.getId().toString())
                .name(owner.getFirstName() + " " + owner.getLastName())
                .city(owner.getAddress().getCity())
                .street(owner.getAddress().getStreet())
                .zipcode(owner.getAddress().getZipcode())
                .phone(owner.getPhone())
                .pets(Arrays.asList(
                        OwnerPetsResponseDto.builder()
                                .id("3")
                                .name(requestDto.getPetName())
                                .type(requestDto.getPetType())
                                .birth(requestDto.getPetBirth())
                                .build()
                ))
                .build();
    }
}



















