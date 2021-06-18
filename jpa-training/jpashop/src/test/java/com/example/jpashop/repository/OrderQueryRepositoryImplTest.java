package com.example.jpashop.repository;

import com.example.jpashop.TestConfig;
import com.example.jpashop.domain.*;
import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.domain.item.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestConstructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(TestConfig.class)
class OrderQueryRepositoryImplTest {

    @Autowired OrderRepository orderRepository;
    @Autowired ItemRepository itemRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    @DisplayName("주문번호로 상세 주문 가져오기")
    void findByIdFetch() throws Exception {
        // TODO : OrderDto 만들어서 테스트 진행하기
        // given
        Member member = Member.builder().name("고범석").build();
        memberRepository.save(member);  // 영속성 컨텍스트 저장

        Album item1 = Album.builder().name("앨범1").price(1000).stockQuantity(1000).artist("범석").genre("힙합").build();
        Book item2 = Book.builder().name("책1").price(2000).stockQuantity(2000).author("범석").isbn("123").build();
        Movie item3 = Movie.builder().name("영화").price(3000).stockQuantity(3000).distributor("범석회사").director("범석").build();
        itemRepository.saveAll(List.of(item1, item2, item3));

//        OrderItem.createOrderItem()
        OrderItem orderItem1 = OrderItem.builder().item(item1).count(30).build();
        OrderItem orderItem2 = OrderItem.builder().item(item2).count(30).build();
        OrderItem orderItem3 = OrderItem.builder().item(item3).count(30).build();

        Delivery delivery = Delivery.builder()
                .address(Address.builder().city("서울").street("광진구 중곡동").zipcode("04941").build())
                .status(DeliveryStatus.READY).build();

        Order order = Order.createOrder(member, delivery, List.of(orderItem1, orderItem2, orderItem3));
        orderRepository.save(order);

        em.flush(); em.clear();

        // when
        Optional<Order> findOrder = orderRepository.findIdFetch(order.getId());

        // then
        assertAll(
                () -> assertTrue(findOrder.isPresent()),
                () -> {
                    Order getOrder = findOrder.get();
                    assertEquals(getOrder.getOrderItems().size(), 3);

                    List<Item> items = getOrder.getOrderItems().stream().map(OrderItem::getItem).collect(toList());
                    assertThat(items).extracting("name").contains("앨범1", "책1", "영화");
                    assertNotNull(getOrder.getDelivery());
                });
    }

    @Test
    @DisplayName("멤버 아이디로 모든 주문 가져오기")
    void findByMemberIdFetch() throws Exception {

        // given
        Member member = Member.builder().name("고범석").build();
        memberRepository.save(member);

        Album item1 = Album.builder().name("앨범1").price(1000).stockQuantity(1000).artist("범석").genre("힙합").build();
        Book item2 = Book.builder().name("책1").price(2000).stockQuantity(2000).author("범석").isbn("123").build();
        Movie item3 = Movie.builder().name("영화").price(3000).stockQuantity(3000).distributor("범석회사").director("범석").build();
        itemRepository.saveAll(List.of(item1, item2, item3));

        OrderItem orderItem1 = OrderItem.builder().item(item1).count(30).build();
        OrderItem orderItem2 = OrderItem.builder().item(item2).count(30).build();
        OrderItem orderItem3 = OrderItem.builder().item(item3).count(30).build();

        Delivery delivery = Delivery.builder()
                .address(Address.builder().city("서울").street("광진구 중곡동").zipcode("04941").build())
                .status(DeliveryStatus.READY).build();

        Order order1 = Order.createOrder(member, delivery, List.of(orderItem1, orderItem2, orderItem3));
        Order order2 = Order.createOrder(member, delivery, List.of(orderItem1, orderItem2, orderItem3));
        Order order3 = Order.createOrder(member, delivery, List.of(orderItem1, orderItem2, orderItem3));
        orderRepository.saveAll(List.of(order1, order2, order3));

        em.flush(); em.clear();

        // when
        List<Order> findOrders = orderRepository.findByMemberIdFetch(member.getId());

        // then
        assertAll(() -> {
            assertEquals(findOrders.size(), 3);

            Member orderMember = findOrders.stream().map(Order::getMember).distinct().findFirst().get();
            assertNotNull(orderMember);
            assertEquals(orderMember.getId(), member.getId());
        });
    }
}