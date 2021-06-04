package com.example.jpashop.service;

import com.example.jpashop.domain.Delivery;
import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.Order;
import com.example.jpashop.domain.OrderItem;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.dto.OrderDto;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.repository.MemberRepository;
import com.example.jpashop.repository.OrderRepository;
import com.example.jpashop.util.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Override
    public void createOrder(OrderDto orderDto) {

        // TODO : 도메인에게 Delivery 생성 위임하기
        // member
        Member member = memberRepository.findById(Long.parseLong(orderDto.getMemberId())).orElseThrow();

        // delivery
        Delivery delivery = Delivery.createDelivery(orderDto.getAddressDto());

        // orderItems
        List<OrderItem> orderItems = orderDto.getOrderItemDtos()
                .stream().map(i -> {
                    Item item = itemRepository.findById(Long.parseLong(i.getItemId())).orElseThrow();
                    return OrderItem.createOrderItem(item, i);
                }).collect(Collectors.toList());

        Order order = Order.createOrder(member, delivery, orderItems);
        orderRepository.save(order);
        
        // TODO : ORDER_ITEM 에서 ORDER ID가 NULL로 나옴
    }

    @Override
    public void cancelOrder(String orderId) {

    }
}
