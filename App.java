package com.billing;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BillingSystem billingSystem = new BillingSystem();
        
        System.out.println("=== Internet Data Usage Billing System ===");
        
        while (true) {
            System.out.print("\nEnter Customer Name (or type 'exit' to quit): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter Plan Type (Basic, Standard, Premium): ");
            String planType = scanner.nextLine();

            System.out.print("Enter Total Data Consumed (in GB): ");
            double dataConsumed;
            try {
                dataConsumed = Double.parseDouble(scanner.nextLine());
                if (dataConsumed < 0) {
                    System.out.println("Data consumption cannot be negative. Try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Use numeric values.");
                continue;
            }

            try {
                double totalBill = billingSystem.calculateBill(planType, dataConsumed);
                System.out.println("\n------- GENERATED INVOICE -------");
                System.out.println("Customer Name : " + name);
                System.out.println("Selected Plan : " + planType.toUpperCase());
                System.out.println("Data Consumed : " + dataConsumed + " GB");
                System.out.printf("Total Amount  : Rs. %.2f\n", totalBill);
                System.out.println("---------------------------------");
            } catch (IllegalArgumentException e) {
                System.out.println("Billing Error: " + e.getMessage());
            }
        }
        System.out.println("\nSystem stopped.");
        scanner.close();
    }
}
