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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.*;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Override
    public void createOrder(OrderDto orderDto) {

        Member member = memberRepository.findById(Long.parseLong(orderDto.getMemberId())).orElseThrow();
        Delivery delivery = Delivery.createDelivery(orderDto.getAddressDto());

        List<Item> items = itemRepository.findByIdIn(orderDto.getOrderItemDtos()
                .stream().map(o -> Long.parseLong(o.getItemId())).collect(toList()))
                .stream().sorted(Comparator.comparing(Item::getId)).collect(toList());

        List<OrderItem> orderItems = OrderItem.createOrderItem(orderDto.getOrderItemDtos(), items);
        Order order = Order.createOrder(member, delivery, orderItems);
        orderRepository.save(order);
    }

    @Override
    public void cancelOrder(String orderId) {

        Order order = orderRepository.findIdFetch(Long.parseLong(orderId)).orElseThrow();
        order.cancelOrder();
    }
}
