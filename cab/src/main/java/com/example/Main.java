package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Initialize the RideRepository and InvoiceService
        RideRepository rideRepository = new RideRepository();
        InvoiceService invoiceService = new InvoiceService(rideRepository);

        // Add some normal and premium rides for a user
        String userId = "user123";
        rideRepository.addRides(userId, Arrays.asList(
                new Ride(2.5, 10, RideType.NORMAL),
                new Ride(0.3, 5, RideType.PREMIUM),
                new Ride(1.2, 3, RideType.NORMAL)
        ));

        // Retrieve the invoice for the user
        Invoice invoice = invoiceService.getInvoiceForUser(userId);

        // Print the invoice details
        if (invoice != null) {
            System.out.println("Invoice for UserID: " + userId);
            System.out.println("Total Rides: " + invoice.getTotalRides());
            System.out.println("Total Fare: Rs. " + invoice.getTotalFare());
            System.out.println("Average Fare per Ride: Rs. " + invoice.getAverageFare());
        } else {
            System.out.println("No rides found for UserID: " + userId);
        }
    }
}
