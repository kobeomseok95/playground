package com.example.jpashop.service;

import com.example.jpashop.domain.Delivery;
import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.Order;
import com.example.jpashop.domain.OrderItem;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.dto.OrderDto;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.repository.MemberRepository;
import com.example.jpashop.repository.OrderItemRepository;
import com.example.jpashop.repository.OrderRepository;
import com.example.jpashop.util.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public void createOrder(OrderDto orderDto) {

        // TODO : 벌크 연산 해결 참고하기, 2개의 아이템 주문 기준 총 9번의 쿼리 발생
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
    }

    @Override
    public void cancelOrder(String orderId) {

        Order order = orderRepository.findIdFetch(Long.parseLong(orderId)).orElseThrow();
        order.cancelOrder();
    }
}
