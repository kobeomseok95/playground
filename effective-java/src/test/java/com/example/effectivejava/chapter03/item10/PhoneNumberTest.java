package com.example.effectivejava.chapter03.item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PhoneNumberTest {

    @Test
    @DisplayName("compareTo Test")
    void ex1() throws Exception {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        PhoneNumber p3 = new PhoneNumber(123, 130, 130);
        PhoneNumber p1 = new PhoneNumber(123, 123, 123);
        PhoneNumber p2 = new PhoneNumber(122, 123, 123);
        phoneNumbers.add(p1);
        phoneNumbers.add(p2);
        phoneNumbers.add(p3);
        Collections.sort(phoneNumbers);
        for (PhoneNumber phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }
}