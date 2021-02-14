package com.clone.petclinic.controller;

import com.clone.petclinic.controller.dto.AddVisitRequestDto;
import com.clone.petclinic.controller.dto.OwnerOneResponseDto;
import com.clone.petclinic.controller.dto.VisitResponseDto;
import com.clone.petclinic.service.OwnerService;
import com.clone.petclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/owners/{ownerId}/pets/{petId}")
public class VisitController {

    private final VisitService visitService;
    private final OwnerService ownerService;

    @PostMapping("/visits/new")
    public OwnerOneResponseDto createVisit(@PathVariable("ownerId") @NotNull Long ownerId,
                                        @PathVariable("petId") @NotNull Long petId,
                                        @RequestBody @Valid AddVisitRequestDto request) {
        visitService.addVisit(ownerId, petId, request);
        return ownerService.findOne(ownerId);
    }
}
