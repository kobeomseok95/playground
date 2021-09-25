package com.example.domain;

import lombok.Getter;

@Getter
public class CustomerNameUpdate extends CustomerUpdate{

    private final String firstName;
    private final String middleName;
    private final String lastName;

    public CustomerNameUpdate(Long customerId, String firstName, String middleName, String lastName) {
        super(customerId);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }



}
