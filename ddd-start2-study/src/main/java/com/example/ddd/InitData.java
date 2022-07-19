package com.example.ddd;

import com.example.ddd.catalog.product.domain.Product;
import com.example.ddd.catalog.product.domain.ProductRepository;
import com.example.ddd.common.domainmodel.Money;
import com.example.ddd.member.command.domain.Member;
import com.example.ddd.member.command.domain.MemberRepository;
import com.example.ddd.order.command.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class InitData {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public void postConstruct() {
        memberRepository.save(
                Member.builder()
                        .memberName("고범석")
                        .phone("010-1234-1234")
                        .build()
        );
        productRepository.save(
                Product.builder()
                        .name("예제 상품")
                        .price(Money.of(10000L))
                        .build()
        );
    }
}
