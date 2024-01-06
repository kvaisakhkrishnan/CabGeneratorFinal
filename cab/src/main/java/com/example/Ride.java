package com.example;

public class Ride {
    private double distance;
    private double time;
    private RideType rideType;

    public Ride(double distance, double time, RideType rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }

    // Getters
    public double getDistance() { return distance; }
    public double getTime() { return time; }
    public RideType getRideType() { return rideType; }
}

