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

        // TODO : 아이템들을 한번에 가져오고 재고를 remove 해주는 방법 고민하기
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
        
        // TODO : 주문 취소 작성시 Order 객체 상태가 Cancel, 아이템들의 재고 원상태로 복구
        
    }
}
