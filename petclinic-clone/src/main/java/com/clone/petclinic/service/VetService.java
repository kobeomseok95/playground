package com.clone.petclinic.service;

import com.clone.petclinic.controller.dto.VetsDto;
import com.clone.petclinic.domain.Vet;
import com.clone.petclinic.repository.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class VetService {

    private final VetRepository vetRepository;

    @Cacheable(cacheNames = "vets")
    public List<VetsDto> getVetsAndSpecialities(){
        Collection<Vet> vets = vetRepository.findAllFetch();
        return vets.stream()
                .map(VetsDto::new)
                .collect(Collectors.toList());
    }
}
