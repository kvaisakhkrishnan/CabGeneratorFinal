package com.example;

import java.util.List;

public class InvoiceService {
    private RideRepository rideRepository;
    private CabInvoiceGenerator invoiceGenerator;

    public InvoiceService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
        this.invoiceGenerator = new CabInvoiceGenerator();
    }

    public Invoice getInvoiceForUser(String userId) {
        List<Ride> rides = rideRepository.getRides(userId);
        if (rides == null || rides.isEmpty()) {
            return null;
        }
        return invoiceGenerator.generateInvoiceForRides(rides.toArray(new Ride[0]));
    }
}
