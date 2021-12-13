package com.example.houseutils.policy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrokeragePolicyTest {

    PurchaseBrokeragePolicy purchaseBrokeragePolicy;
    RentBrokeragePolicy rentBrokeragePolicy;

    @BeforeEach
    void setUp() throws Exception {
        purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();
        rentBrokeragePolicy = new RentBrokeragePolicy();
    }

    @Test
    @DisplayName("매매/교환, 모든 조건")
    void testPurchasedBrokeragePolicy() throws Exception {
        // then
        assertAll(
                () -> assertEquals(purchaseBrokeragePolicy.calculate(30_000_000L), 180_000L),
                () -> assertEquals(purchaseBrokeragePolicy.calculate(100_000_000L), 500_000L),
                () -> assertEquals(purchaseBrokeragePolicy.calculate(500_000_000L), 2_000_000L),
                () -> assertEquals(purchaseBrokeragePolicy.calculate(800_000_000L), 4_000_000L),
                () -> assertEquals(purchaseBrokeragePolicy.calculate(1_000_000_000L), 9_000_000L)
        );
    }

    @Test
    @DisplayName("임대차등, 모든 조건")
    void testRentBrokeragePolicy() throws Exception {
        // then
        assertAll(
                () -> assertEquals(rentBrokeragePolicy.calculate(30_000_000L), 150_000L),
                () -> assertEquals(rentBrokeragePolicy.calculate(100_000_000L), 300_000L),
                () -> assertEquals(rentBrokeragePolicy.calculate(500_000_000L), 2_000_000L),
                () -> assertEquals(rentBrokeragePolicy.calculate(800_000_000L), 6_400_000L),
                () -> assertEquals(rentBrokeragePolicy.calculate(1_000_000_000L), 8_000_000L)
        );
    }
}
