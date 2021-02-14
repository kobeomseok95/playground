package com.clone.petclinic.controller;

import com.clone.petclinic.controller.dto.VetsDto;
import com.clone.petclinic.domain.VetSpeciality;
import com.clone.petclinic.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VetController {

    private final VetService vetService;

    @GetMapping("/vets")
    public List<VetsDto> vets() {
        return vetService.getVetsAndSpecialities();
    }
}
