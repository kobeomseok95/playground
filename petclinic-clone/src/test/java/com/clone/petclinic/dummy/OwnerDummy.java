package com.clone.petclinic.dummy;

import com.clone.petclinic.controller.dto.OwnerJoinAndEditRequestDto;
import com.clone.petclinic.domain.Owner;
import com.clone.petclinic.domain.base.Address;

import java.util.HashSet;

public class OwnerDummy {
    public static Owner createOwner() {
        return Owner.builder()
                .firstName("beomseok")
                .lastName("ko")
                .phone("010-1111-1111")
                .address(
                        Address.builder()
                                .city("test")
                                .street("test")
                                .zipcode("test")
                                .build()
                )
                .pets(new HashSet<>())
                .build();
    }

    public static Owner multipleCreateOwner(int number) {
        return Owner.builder()
                .firstName("beomseok")
                .lastName("ko")
                .phone("010-1111-1111")
                .address(
                        Address.builder()
                                .city("test" + Integer.toString(number))
                                .street("test" + Integer.toString(number))
                                .zipcode("test" + Integer.toString(number))
                                .build()
                )
                .build();
    }

    public static OwnerJoinAndEditRequestDto createOwnerJoinAndEditRequestDto() {
        return OwnerJoinAndEditRequestDto.builder()
                .firstName("edit")
                .lastName("edit")
                .phone("edit")
                .city("edit")
                .street("edit")
                .zipcode("edit")
                .build();
    }
}
