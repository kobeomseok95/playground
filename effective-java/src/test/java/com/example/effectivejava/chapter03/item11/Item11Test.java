package com.example.effectivejava.chapter03.item11;

import com.example.effectivejava.chapter03.item10.PhoneNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Item11Test {

    @Test
    @DisplayName("hashCode")
    void ex1(){
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 123, 1234), "고범석");
        System.out.println(new PhoneNumber(707, 123, 1234));
        assertNotNull(m.get(new PhoneNumber(707, 123, 1234)));
    }
}
