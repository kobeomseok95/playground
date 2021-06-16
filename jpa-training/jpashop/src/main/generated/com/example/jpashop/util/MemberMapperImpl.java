package com.example.jpashop.util;

import com.example.jpashop.domain.Address;
import com.example.jpashop.domain.Delivery;
import com.example.jpashop.domain.DeliveryStatus;
import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.Order;
import com.example.jpashop.domain.OrderItem;
import com.example.jpashop.domain.OrderStatus;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.dto.MemberDto;
import com.example.jpashop.dto.MemberDto.DeliveryDto;
import com.example.jpashop.dto.MemberDto.MembersOrderDto;
import com.example.jpashop.dto.MemberDto.OrderItemsDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-16T13:26:24+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberDtoToMember(MemberDto request) {
        if ( request == null ) {
            return null;
        }

        Address address = null;
        List<Order> orders = null;
        String name = null;

        address = memberDtoToAddress( request );
        orders = membersOrderDtoListToOrderList( request.getOrders() );
        name = request.getName();

        Long id = null;

        Member member = new Member( id, name, address, orders );

        return member;
    }

    @Override
    public MemberDto memberToMemberDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDto memberDto = new MemberDto();

        memberDto.setCity( memberAddressCity( member ) );
        memberDto.setStreet( memberAddressStreet( member ) );
        memberDto.setZipcode( memberAddressZipcode( member ) );
        memberDto.setName( member.getName() );
        memberDto.setOrders( orderListToMembersOrderDtoList( member.getOrders() ) );

        return memberDto;
    }

    protected Address memberDtoToAddress(MemberDto memberDto) {
        if ( memberDto == null ) {
            return null;
        }

        String city = null;
        String street = null;
        String zipcode = null;

        city = memberDto.getCity();
        street = memberDto.getStreet();
        zipcode = memberDto.getZipcode();

        Address address = new Address( city, street, zipcode );

        return address;
    }

    protected OrderItem orderItemsDtoToOrderItem(OrderItemsDto orderItemsDto) {
        if ( orderItemsDto == null ) {
            return null;
        }

        int count = 0;

        count = orderItemsDto.getCount();

        Long id = null;
        Order order = null;
        Item item = null;

        OrderItem orderItem = new OrderItem( id, order, item, count );

        return orderItem;
    }

    protected List<OrderItem> orderItemsDtoListToOrderItemList(List<OrderItemsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItem> list1 = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemsDto orderItemsDto : list ) {
            list1.add( orderItemsDtoToOrderItem( orderItemsDto ) );
        }

        return list1;
    }

    protected Delivery deliveryDtoToDelivery(DeliveryDto deliveryDto) {
        if ( deliveryDto == null ) {
            return null;
        }

        Long id = null;
        Order order = null;
        Address address = null;
        DeliveryStatus status = null;

        Delivery delivery = new Delivery( id, order, address, status );

        return delivery;
    }

    protected Order membersOrderDtoToOrder(MembersOrderDto membersOrderDto) {
        if ( membersOrderDto == null ) {
            return null;
        }

        List<OrderItem> orderItems = null;
        Delivery delivery = null;

        orderItems = orderItemsDtoListToOrderItemList( membersOrderDto.getOrderItems() );
        delivery = deliveryDtoToDelivery( membersOrderDto.getDelivery() );

        Long id = null;
        Member member = null;
        OrderStatus status = null;

        Order order = new Order( id, member, orderItems, delivery, status );

        return order;
    }

    protected List<Order> membersOrderDtoListToOrderList(List<MembersOrderDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Order> list1 = new ArrayList<Order>( list.size() );
        for ( MembersOrderDto membersOrderDto : list ) {
            list1.add( membersOrderDtoToOrder( membersOrderDto ) );
        }

        return list1;
    }

    private String memberAddressCity(Member member) {
        if ( member == null ) {
            return null;
        }
        Address address = member.getAddress();
        if ( address == null ) {
            return null;
        }
        String city = address.getCity();
        if ( city == null ) {
            return null;
        }
        return city;
    }

    private String memberAddressStreet(Member member) {
        if ( member == null ) {
            return null;
        }
        Address address = member.getAddress();
        if ( address == null ) {
            return null;
        }
        String street = address.getStreet();
        if ( street == null ) {
            return null;
        }
        return street;
    }

    private String memberAddressZipcode(Member member) {
        if ( member == null ) {
            return null;
        }
        Address address = member.getAddress();
        if ( address == null ) {
            return null;
        }
        String zipcode = address.getZipcode();
        if ( zipcode == null ) {
            return null;
        }
        return zipcode;
    }

    protected DeliveryDto deliveryToDeliveryDto(Delivery delivery) {
        if ( delivery == null ) {
            return null;
        }

        DeliveryDto deliveryDto = new DeliveryDto();

        return deliveryDto;
    }

    protected OrderItemsDto orderItemToOrderItemsDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemsDto orderItemsDto = new OrderItemsDto();

        orderItemsDto.setCount( orderItem.getCount() );

        return orderItemsDto;
    }

    protected List<OrderItemsDto> orderItemListToOrderItemsDtoList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemsDto> list1 = new ArrayList<OrderItemsDto>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( orderItemToOrderItemsDto( orderItem ) );
        }

        return list1;
    }

    protected MembersOrderDto orderToMembersOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        MembersOrderDto membersOrderDto = new MembersOrderDto();

        membersOrderDto.setDelivery( deliveryToDeliveryDto( order.getDelivery() ) );
        membersOrderDto.setOrderItems( orderItemListToOrderItemsDtoList( order.getOrderItems() ) );

        return membersOrderDto;
    }

    protected List<MembersOrderDto> orderListToMembersOrderDtoList(List<Order> list) {
        if ( list == null ) {
            return null;
        }

        List<MembersOrderDto> list1 = new ArrayList<MembersOrderDto>( list.size() );
        for ( Order order : list ) {
            list1.add( orderToMembersOrderDto( order ) );
        }

        return list1;
    }
}
