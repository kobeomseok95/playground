package com.example.jpashop.util;

import com.example.jpashop.domain.Member;
import com.example.jpashop.dto.MemberDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MemberMapper {

    MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);

    @Mapping(source = "city", target = "address.city")
    @Mapping(source = "street", target = "address.street")
    @Mapping(source = "zipcode", target = "address.zipcode")
    Member memberDtoToMember(MemberDto request);

    @Mapping(source = "address.city", target = "city")
    @Mapping(source = "address.street", target = "street")
    @Mapping(source = "address.zipcode", target = "zipcode")
    MemberDto memberToMemberDto(Member member);
}
