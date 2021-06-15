package com.example.jpashop.util;

import com.example.jpashop.domain.Address;
import com.example.jpashop.domain.Delivery;
import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.Order;
import com.example.jpashop.domain.OrderItem;
import com.example.jpashop.domain.OrderStatus;
import com.example.jpashop.dto.MemberDto;
import com.example.jpashop.dto.OrderDto;
import com.example.jpashop.dto.OrderDto.AddressDto;
import com.example.jpashop.dto.OrderDto.OrderItemDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-15T17:18:06+0900",
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
        orders = orderDtoListToOrderList( request.getOrders() );
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

        String city = null;
        String street = null;
        String zipcode = null;
        String name = null;
        List<OrderDto> orders = null;

        city = memberAddressCity( member );
        street = memberAddressStreet( member );
        zipcode = memberAddressZipcode( member );
        name = member.getName();
        orders = orderListToOrderDtoList( member.getOrders() );

        MemberDto memberDto = new MemberDto( name, city, street, zipcode, orders );

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

    protected Order orderDtoToOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Long id = null;
        Member member = null;
        List<OrderItem> orderItems = null;
        Delivery delivery = null;
        OrderStatus status = null;

        Order order = new Order( id, member, orderItems, delivery, status );

        return order;
    }

    protected List<Order> orderDtoListToOrderList(List<OrderDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Order> list1 = new ArrayList<Order>( list.size() );
        for ( OrderDto orderDto : list ) {
            list1.add( orderDtoToOrder( orderDto ) );
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

    protected OrderDto orderToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        String memberId = null;
        AddressDto addressDto = null;
        List<OrderItemDto> orderItemDtos = null;

        OrderDto orderDto = new OrderDto( memberId, addressDto, orderItemDtos );

        return orderDto;
    }

    protected List<OrderDto> orderListToOrderDtoList(List<Order> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDto> list1 = new ArrayList<OrderDto>( list.size() );
        for ( Order order : list ) {
            list1.add( orderToOrderDto( order ) );
        }

        return list1;
    }
}
