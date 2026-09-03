package com.billing;

public class BillingSystem {
    public static final String BASIC = "basic";
    public static final String STANDARD = "standard";
    public static final String PREMIUM = "premium";

    public double calculateBill(String planType, double dataConsumed) {
        double baseRate;
        double dataLimit; 
        double overageRate; 

        switch (planType.toLowerCase().trim()) {
            case BASIC:
                baseRate = 300.0;
                dataLimit = 10.0;
                overageRate = 20.0;
                break;
            case STANDARD:
                baseRate = 600.0;
                dataLimit = 50.0;
                overageRate = 15.0;
                break;
            case PREMIUM:
                baseRate = 1000.0;
                dataLimit = 150.0;
                overageRate = 10.0;
                break;
            default:
                throw new IllegalArgumentException("Unknown Plan Type: " + planType);
        }

        double totalBill = baseRate;
        if (dataConsumed > dataLimit) {
            double extraUsage = dataConsumed - dataLimit;
            totalBill += extraUsage * overageRate;
        }
        return totalBill;
    }
}
