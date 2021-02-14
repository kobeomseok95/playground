package com.clone.petclinic.controller;

import com.clone.petclinic.controller.dto.VetsDto;
import com.clone.petclinic.service.VetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VetController.class)
class VetControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    VetService vetService;

    @Test
    void vetsTest() throws Exception {

        //given
        List<VetsDto> dtos = createVetsDto();
        when(vetService.getVetsAndSpecialities())
                .thenReturn(dtos);
        
        //when
        final ResultActions actions = mvc.perform(get("/vets")
                .contentType(MediaType.APPLICATION_JSON));
        
        //then
        actions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("vet1")))
                .andExpect(jsonPath("$[0].specialities[0]", is("test1")))
                .andExpect(jsonPath("$[0].specialities[1]", is("test2")))
                .andExpect(jsonPath("$[1].name", is("vet2")))
                .andExpect(jsonPath("$[1].specialities[0]", is("test2")))
                .andExpect(jsonPath("$[1].specialities[1]", is("test3")))
                .andDo(print());
        verify(vetService, times(1))
                .getVetsAndSpecialities();
    }

    private List<VetsDto> createVetsDto() {
        return Arrays.asList(
                VetsDto.builder()
                        .name("vet1")
                        .specialities(
                                Arrays.asList(
                                        "test1", "test2"
                                )
                        )
                        .build(),
                VetsDto.builder()
                        .name("vet2")
                        .specialities(
                                Arrays.asList(
                                        "test2", "test3"
                                )
                        )
                        .build());
    }
}