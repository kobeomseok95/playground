package com.example.houseutils.service;

import com.example.houseutils.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    public Long getPriceOrThrow(Long apartmentId) {
        return apartmentRepository.findById(apartmentId)
                .orElseThrow(() -> new IllegalArgumentException("없음"))
                .getPrice();
    }
}
