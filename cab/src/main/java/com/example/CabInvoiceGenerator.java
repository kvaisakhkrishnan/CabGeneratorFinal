package com.example;

public class CabInvoiceGenerator {

    private static final double NORMAL_RATE_PER_KILOMETER = 10;
    private static final double NORMAL_RATE_PER_MINUTE = 1;
    private static final double NORMAL_MINIMUM_FARE = 5;

    private static final double PREMIUM_RATE_PER_KILOMETER = 15;
    private static final double PREMIUM_RATE_PER_MINUTE = 2;
    private static final double PREMIUM_MINIMUM_FARE = 20;


    public double calculateFare(double distance, double time, RideType rideType) {
        double totalFare;
        if (rideType == RideType.PREMIUM) {
            totalFare = distance * PREMIUM_RATE_PER_KILOMETER + time * PREMIUM_RATE_PER_MINUTE;
            return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
        } else {
            totalFare = distance * NORMAL_RATE_PER_KILOMETER + time * NORMAL_RATE_PER_MINUTE;
            return Math.max(totalFare, NORMAL_MINIMUM_FARE);
        }
    }

    public double calculateTotalFareForMultipleRides(Ride[] rides) {
        double totalFare = 0;
        for(Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
        }
        return totalFare;
    }

    public Invoice generateInvoiceForRides(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
        }
        int totalRides = rides.length;
        double averageFare = (totalRides > 0) ? totalFare / totalRides : 0;
        return new Invoice(totalRides, totalFare, averageFare);
    }
}