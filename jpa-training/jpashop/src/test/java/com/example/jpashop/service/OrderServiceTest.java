package com.example.jpashop.service;

import com.example.jpashop.domain.Delivery;
import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.Order;
import com.example.jpashop.domain.OrderItem;
import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.dto.OrderDto;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.repository.MemberRepository;
import com.example.jpashop.repository.OrderRepository;
import com.example.jpashop.util.OrderMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock OrderRepository orderRepository;
    @Mock MemberRepository memberRepository;
    @Mock ItemRepository itemRepository;
    @InjectMocks OrderServiceImpl orderService;

    @Test
    @DisplayName("주문하기")
    void createOrder() throws Exception {

        // given
        OrderDto orderDto = OrderDto.builder().memberId("1")
                .addressDto(OrderDto.AddressDto.builder().build())
                .orderItemDtos(List.of(OrderDto.OrderItemDto.builder().itemId("1").count(10).build()))
                .build();
        Member member = mock(Member.class);
        when(memberRepository.findById(Long.parseLong(orderDto.getMemberId()))).thenReturn(Optional.of(member));

        MockedStatic<Delivery> staticDelivery = mockStatic(Delivery.class);
        Delivery delivery = mock(Delivery.class);
        staticDelivery.when(() -> Delivery.createDelivery(orderDto.getAddressDto())).thenReturn(delivery);

        OrderItem orderItem = mock(OrderItem.class);
        List<OrderItem> orderItems = List.of(orderItem);
        Album album = mock(Album.class);
        when(itemRepository.findById(Long.parseLong(orderDto.getOrderItemDtos().get(0).getItemId())))
                .thenReturn(Optional.of(album));
        MockedStatic<OrderItem> staticOrderItem = mockStatic(OrderItem.class);
        staticOrderItem.when(() -> OrderItem.createOrderItem(album, orderDto.getOrderItemDtos().get(0)))
                .thenReturn(orderItem);

        Order order = mock(Order.class);
        MockedStatic<Order> staticOrder = mockStatic(Order.class);
        staticOrder.when(() -> Order.createOrder(member, delivery, orderItems)).thenReturn(order);

        // when
        orderService.createOrder(orderDto);

        // then
        verify(memberRepository).findById(anyLong());
        staticDelivery.verify(() -> Delivery.createDelivery(orderDto.getAddressDto()));
        verify(itemRepository).findById(Long.parseLong(orderDto.getOrderItemDtos().get(0).getItemId()));
        staticOrderItem.verify(() -> OrderItem.createOrderItem(album, orderDto.getOrderItemDtos().get(0)));
        staticOrder.verify(() -> Order.createOrder(member, delivery, orderItems));
        verify(orderRepository).save(order);
    }

    @Test
    @DisplayName("주문 취소하기")
    void cancelOrder() throws Exception {

        // given
        Order order = mock(Order.class);
        when(orderRepository.findIdFetch(anyLong())).thenReturn(Optional.of(order));

        // when
        orderService.cancelOrder("1");

        // then
        verify(orderRepository).findIdFetch(anyLong());
    }
}
