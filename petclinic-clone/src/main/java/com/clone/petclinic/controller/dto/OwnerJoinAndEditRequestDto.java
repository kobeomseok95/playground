package com.clone.petclinic.controller.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OwnerJoinAndEditRequestDto {

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Pattern(regexp = "(\\d{3})-(\\d{3,4})-(\\d{4})")
    private String phone;

    @NotBlank
    private String city;

    private String street;
    private String zipcode;
}
