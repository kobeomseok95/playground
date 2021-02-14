package com.clone.petclinic.controller;

import com.clone.petclinic.controller.dto.OwnerJoinAndEditRequestDto;
import com.clone.petclinic.controller.dto.OwnerMultipleResponseDto;
import com.clone.petclinic.controller.dto.OwnerOneResponseDto;
import com.clone.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @PostMapping("/new")
    public OwnerOneResponseDto join(@RequestBody @Valid OwnerJoinAndEditRequestDto dto) {
        Long ownerId = ownerService.join(dto);
        return ownerService.findOne(ownerId);
    }

    @PutMapping("/{id}")
    public OwnerOneResponseDto editOwner(@PathVariable("id") @NotNull Long ownerId,
                                         @RequestBody @Valid OwnerJoinAndEditRequestDto request) {
        ownerService.edit(ownerId, request);
        return ownerService.findOne(ownerId);
    }

    @GetMapping("")
    public List<OwnerMultipleResponseDto> owners(@RequestParam(value = "lastName", required = false) @NotNull String lastName){
        return ownerService.findByLastName(lastName);
    }

    @GetMapping("/{ownerId}")
    public OwnerOneResponseDto ownerOne(@PathVariable("ownerId") @NotNull Long ownerId){
        return ownerService.findOne(ownerId);
    }
}
