package com.clone.petclinic.domain;

import com.clone.petclinic.controller.dto.OwnerJoinAndEditRequestDto;
import com.clone.petclinic.domain.base.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Embedded
    private Address address;

    @Column(nullable = false, length = 13)
    private String phone;

    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    //====연관관계 편의 메서드====
    public void saveOrEdit(OwnerJoinAndEditRequestDto dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.address = Address.builder()
                .city(dto.getCity())
                .street(dto.getStreet())
                .zipcode(dto.getZipcode())
                .build();
        this.phone = dto.getPhone();
    }

    public void addPets(Pet pet) {
        if (pets == null) {
            pets = new HashSet<>();
        }
        pets.add(pet);
    }
}
