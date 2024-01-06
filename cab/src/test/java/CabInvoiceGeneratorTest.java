import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.CabInvoiceGenerator;
import com.example.Invoice;
import com.example.Ride;
import com.example.RideType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
    private static CabInvoiceGenerator invoiceGenerator;

    @BeforeAll
    public static void setup() {
        invoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    public void givenNormalRide_ShouldReturnCorrectFare() {
        Ride ride = new Ride(2.0, 5, RideType.NORMAL);
        double fare = invoiceGenerator.calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
        assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenPremiumRide_ShouldReturnCorrectFare() {
        Ride ride = new Ride(2.0, 5, RideType.PREMIUM);
        double fare = invoiceGenerator.calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
        assertEquals(40, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnCorrectInvoice() {
        Ride[] rides = {
                new Ride(2.0, 5, RideType.NORMAL),
                new Ride(0.5, 3, RideType.PREMIUM)
        };
        Invoice invoice = invoiceGenerator.generateInvoiceForRides(rides);
        assertEquals(2, invoice.getTotalRides());
        assertEquals(46, invoice.getTotalFare(), 0.0);
        assertEquals(23, invoice.getAverageFare(), 0.0);
    }

}