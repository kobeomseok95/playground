package com.example.jpashop.util;

import com.example.jpashop.domain.Address;
import com.example.jpashop.domain.Address.AddressBuilder;
import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.Member.MemberBuilder;
import com.example.jpashop.dto.MemberDto.JoinRequest;
import com.example.jpashop.dto.MemberDto.JoinResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-31T09:16:47+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member joinRequestToMember(JoinRequest request) {
        if ( request == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.address( joinRequestToAddress( request ) );
        member.name( request.getName() );

        return member.build();
    }

    @Override
    public JoinResponse memberToJoinResponse(Member member) {
        if ( member == null ) {
            return null;
        }

        String city = null;
        String street = null;
        String zipcode = null;
        String name = null;

        city = memberAddressCity( member );
        street = memberAddressStreet( member );
        zipcode = memberAddressZipcode( member );
        name = member.getName();

        JoinResponse joinResponse = new JoinResponse( name, city, street, zipcode );

        return joinResponse;
    }

    protected Address joinRequestToAddress(JoinRequest joinRequest) {
        if ( joinRequest == null ) {
            return null;
        }

        AddressBuilder address = Address.builder();

        address.city( joinRequest.getCity() );
        address.street( joinRequest.getStreet() );
        address.zipcode( joinRequest.getZipcode() );

        return address.build();
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
}