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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock OrderRepository orderRepository;
    @Mock MemberRepository memberRepository;
    @Mock ItemRepository itemRepository;
    @Spy @InjectMocks OrderServiceImpl orderService;

    @Test
    @DisplayName("주문하기")
    void createOrder() throws Exception {
        
        // TODO : 테스트 다시 돌려보기
        // given
//        OrderDto request = OrderDto.builder()
//                .memberId("1").addressDto(OrderDto.AddressDto.builder().street("").street("").zipcode("").build())
//                .orderItemDtos(List.of(OrderDto.OrderItemDto.builder().itemId("1").build(),
//                        OrderDto.OrderItemDto.builder().itemId("2").build())).build();
//        Member member = mock(Member.class);
//        Delivery delivery = mock(Delivery.class);
//        MockedStatic<Delivery> staticDelivery = mockStatic(Delivery.class);
//        List<OrderItem> orderItems = mock(List.class);
//        Order order = mock(Order.class);
//        MockedStatic<Order> staticOrder = mockStatic(Order.class);
//        Item item = mock(Item.class);
//
//        when(memberRepository.findById(Long.parseLong(request.getMemberId())))
//                .thenReturn((Optional.of(member)));
//        staticDelivery.when(() -> Delivery.createDelivery(request.getAddressDto()))
//                .thenReturn(delivery);
//        when(itemRepository.findById(anyLong())).thenReturn(Optional.of(item));
//        when(request.getOrderItemDtos()
//                .stream().map(i -> (OrderItem.createOrderItem(itemRepository.findById(Long.parseLong(i.getItemId())).orElseThrow(), i)))
//                .collect(Collectors.toList()))
//                .thenReturn(orderItems);
//        staticOrder.when(() -> Order.createOrder(member, delivery, orderItems))
//                .thenReturn(order);
//
//        // when
//        orderService.createOrder(request);
//
//        // then
//        verify(memberRepository).findById(anyLong());
//        staticDelivery.verify(() -> Delivery.createDelivery(request.getAddressDto()));
//        verify(itemRepository, calls(2)).findById(anyLong());
//        staticOrder.verify(() -> Order.createOrder(member, delivery, orderItems));
//        verify(orderRepository).save(order);
    }

    @Test
    @DisplayName("주문 취소하기")
    void cancelOrder() throws Exception {

        // given


        // when


        // then

    }
}
