package com.clone.petclinic.controller.dto;

import com.clone.petclinic.domain.Owner;
import com.clone.petclinic.domain.Pet;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerMultipleResponseDto {

    private String id;
    private String name;
    private String address;
    private String city;
    private String phone;
    private List<String> petNames;

    public OwnerMultipleResponseDto(Owner owner) {
        this.id = owner.getId().toString();
        this.name = owner.getLastName() + " " + owner.getFirstName();
        this.address = owner.getAddress().getStreet() + " " + owner.getAddress().getZipcode();
        this.city = owner.getAddress().getCity();
        this.phone = owner.getPhone();
        this.petNames = owner.getPets().stream()
                            .map(Pet::getName)
                            .collect(Collectors.toList());
    }
}
