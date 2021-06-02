package com.example.jpashop.util;

import com.example.jpashop.domain.Address;
import com.example.jpashop.domain.Address.AddressBuilder;
import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.Member.MemberBuilder;
import com.example.jpashop.dto.MemberDto;
import com.example.jpashop.dto.MemberDto.MemberDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-02T16:57:31+0900",
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

        MemberDtoBuilder memberDto = MemberDto.builder();

        memberDto.city( memberAddressCity( member ) );
        memberDto.street( memberAddressStreet( member ) );
        memberDto.zipcode( memberAddressZipcode( member ) );
        memberDto.name( member.getName() );

        return memberDto.build();
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
