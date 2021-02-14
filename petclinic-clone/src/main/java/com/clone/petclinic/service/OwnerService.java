package com.clone.petclinic.service;

import com.clone.petclinic.controller.dto.OwnerJoinAndEditRequestDto;
import com.clone.petclinic.controller.dto.OwnerMultipleResponseDto;
import com.clone.petclinic.controller.dto.OwnerOneResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OwnerService {

    Long join(OwnerJoinAndEditRequestDto dto);

    void edit(Long id, OwnerJoinAndEditRequestDto dto);

    OwnerOneResponseDto findOne(Long ownerId);

    List<OwnerMultipleResponseDto> findByLastName(String lastName);
}
