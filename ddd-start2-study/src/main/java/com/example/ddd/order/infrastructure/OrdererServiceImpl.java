package com.example.ddd.order.infrastructure;

import com.example.ddd.member.query.MemberData;
import com.example.ddd.member.query.MemberDataJpaRepository;
import com.example.ddd.order.domain.Orderer;
import com.example.ddd.order.domain.OrdererService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdererServiceImpl implements OrdererService {

    private final MemberDataJpaRepository memberDataJpaRepository;

    @Override
    public Orderer createOrderer(Long ordererId) {
        MemberData orderer = memberDataJpaRepository.findById(ordererId)
                .orElseThrow(IllegalArgumentException::new);
        return Orderer.of(orderer);
    }
}
