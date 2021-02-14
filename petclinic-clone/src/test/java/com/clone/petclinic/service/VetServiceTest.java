package com.clone.petclinic.service;

import com.clone.petclinic.controller.dto.VetsDto;
import com.clone.petclinic.domain.Speciality;
import com.clone.petclinic.domain.Vet;
import com.clone.petclinic.domain.VetSpeciality;
import com.clone.petclinic.repository.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VetServiceTest {

    @Mock
    VetRepository vetRepository;
    @InjectMocks
    VetService vetService;

    @Test
    void vets조회() throws Exception{

        //given
        when(vetRepository.findAllFetch())
                .thenReturn(createVets());

        //when
        List<VetsDto> vets = vetService.getVetsAndSpecialities();

        //then
        verify(vetRepository, times(1))
                .findAllFetch();
        assertAll(
                () -> assertEquals(vets.size(), 2),
                () -> assertEquals(vets.get(0).getSpecialities().size(), 2),
                () -> assertEquals(vets.get(1).getSpecialities().size(), 2)
        );
    }

    private Collection<Vet> createVets() {
        Vet vet1 = Vet.builder().id(1L).name("vet1").specialities(new HashSet<>()).build();
        Vet vet2 = Vet.builder().id(2L).name("vet2").specialities(new HashSet<>()).build();

        Speciality speciality1 = Speciality.builder().id(1L).subject("radiology").build();
        Speciality speciality2 = Speciality.builder().id(2L).subject("dentistry").build();
        Speciality speciality3 = Speciality.builder().id(3L).subject("surgery").build();

        VetSpeciality vs1 = VetSpeciality.builder().id(1L).vet(vet1).speciality(speciality1).build();
        vs1.addVetAndSpeciality(vet1);
        VetSpeciality vs2 = VetSpeciality.builder().id(2L).vet(vet1).speciality(speciality2).build();
        vs2.addVetAndSpeciality(vet1);
        VetSpeciality vs3 = VetSpeciality.builder().id(3L).vet(vet2).speciality(speciality2).build();
        vs3.addVetAndSpeciality(vet2);
        VetSpeciality vs4 = VetSpeciality.builder().id(4L).vet(vet2).speciality(speciality3).build();
        vs4.addVetAndSpeciality(vet2);

        Collection<Vet> vets = new ArrayList<>();
        vets.add(vet1);
        vets.add(vet2);
        return vets;
    }
}








