package com.billing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BillingSystemTest {
    private final BillingSystem billingSystem = new BillingSystem();

    @Test
    public void testBasicPlanWithinLimit() {
        double bill = billingSystem.calculateBill("basic", 8.0);
        assertEquals(300.0, bill, 0.001);
    }

    @Test
    public void testBasicPlanWithOverage() {
        double bill = billingSystem.calculateBill("basic", 12.0);
        assertEquals(340.0, bill, 0.001);
    }

    @Test
    public void testInvalidPlanThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            billingSystem.calculateBill("invalid_plan", 10.0);
        });
    }
}
