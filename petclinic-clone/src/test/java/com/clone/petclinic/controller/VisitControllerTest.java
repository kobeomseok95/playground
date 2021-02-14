package com.clone.petclinic.controller;

import com.clone.petclinic.controller.dto.*;
import com.clone.petclinic.service.OwnerService;
import com.clone.petclinic.service.VisitService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VisitController.class)
class VisitControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    VisitService visitService;

    @MockBean
    OwnerService ownerService;

    @Test
    void visit_추가() throws Exception{

        //given
        AddVisitRequestDto requestDto = createAddVisitRequestDto();
        OwnerOneResponseDto responseDto = createOwnerOneResponseDto();
        when(ownerService.findOne(any(Long.class)))
                .thenReturn(responseDto);

        //when, then
        mockMvc.perform(post("/owners/{ownerId}/pets/{petId}/visits/new", 1L, 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is("1")))
                .andExpect(jsonPath("$.name", is("owner1")))
                .andExpect(jsonPath("$.phone", is("test")))
                .andExpect(jsonPath("$.city", is("test")))
                .andExpect(jsonPath("$.street", is("test")))
                .andExpect(jsonPath("$.zipcode", is("test")))
                .andExpect(jsonPath("$.pets.length()", is(1)))
                .andExpect(jsonPath("$.pets[0].id", is("2")))
                .andExpect(jsonPath("$.pets[0].name", is("owner1pet1")))
                .andExpect(jsonPath("$.pets[0].type", is("snake")))
                .andExpect(jsonPath("$.pets[0].birth").exists())
                .andExpect(jsonPath("$.pets[0].visits.length()", is(1)))
                .andExpect(jsonPath("$.pets[0].visits[0].visitDate").exists())
                .andExpect(jsonPath("$.pets[0].visits[0].description", is("test")));
    }

    private OwnerOneResponseDto createOwnerOneResponseDto() {
        return OwnerOneResponseDto.builder()
                .id("1")
                .name("owner1")
                .phone("test")
                .city("test")
                .street("test")
                .zipcode("test")
                .pets(
                        Arrays.asList(
                                OwnerPetsResponseDto.builder()
                                        .id("2")
                                        .name("owner1pet1")
                                        .type("snake")
                                        .birth(LocalDate.now().toString())
                                        .visits(
                                                Arrays.asList(
                                                        PetsVisitResponseDto.builder()
                                                                .visitDate(LocalDate.now().toString())
                                                                .description("test")
                                                                .build()
                                                )
                                        ).build()
                        )
                )
                .build();
    }

    private AddVisitRequestDto createAddVisitRequestDto() {
        return AddVisitRequestDto.builder()
                .petId("2")
                .date(LocalDate.now().toString())
                .description("test")
                .build();
    }

}










