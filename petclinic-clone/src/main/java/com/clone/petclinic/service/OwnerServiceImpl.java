package com.clone.petclinic.service;

import com.clone.petclinic.controller.dto.OwnerJoinAndEditRequestDto;
import com.clone.petclinic.controller.dto.OwnerMultipleResponseDto;
import com.clone.petclinic.controller.dto.OwnerOneResponseDto;
import com.clone.petclinic.domain.Owner;
import com.clone.petclinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    @Transactional
    public Long join(OwnerJoinAndEditRequestDto dto) {
        Owner owner = new Owner();
        owner.saveOrEdit(dto);
        Owner savedOwner = ownerRepository.save(owner);
        return savedOwner.getId();
    }

    @Override
    @Transactional
    public void edit(Long ownerId, OwnerJoinAndEditRequestDto dto){
        Owner owner = ownerRepository.findById(ownerId).orElseThrow();
        owner.saveOrEdit(dto);
    }

    @Override
    public OwnerOneResponseDto findOne(Long ownerId){
        Owner owner = ownerRepository.findByIdFetch(ownerId).orElseThrow();
        return new OwnerOneResponseDto(owner);
    }

    @Override
    public List<OwnerMultipleResponseDto> findByLastName(String lastName){
        Collection<Owner> owners = ownerRepository.findByLastName(lastName);
        return owners.stream()
                .map(OwnerMultipleResponseDto::new)
                .collect(Collectors.toList());
    }
}
