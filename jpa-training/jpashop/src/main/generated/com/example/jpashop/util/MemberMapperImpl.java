package com.example.jpashop.util;

import com.example.jpashop.domain.Address;
import com.example.jpashop.domain.Address.AddressBuilder;
import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.Member.MemberBuilder;
import com.example.jpashop.dto.MemberDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-31T12:11:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberDtoToMember(MemberDto request) {
        if ( request == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.address( memberDtoToAddress( request ) );
        member.name( request.getName() );

        return member.build();
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

        city = memberAddressCity( member );
        street = memberAddressStreet( member );
        zipcode = memberAddressZipcode( member );
        name = member.getName();

        MemberDto memberDto = new MemberDto( name, city, street, zipcode );

        return memberDto;
    }

    protected Address memberDtoToAddress(MemberDto memberDto) {
        if ( memberDto == null ) {
            return null;
        }

        AddressBuilder address = Address.builder();

        address.city( memberDto.getCity() );
        address.street( memberDto.getStreet() );
        address.zipcode( memberDto.getZipcode() );

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
