import static org.junit.jupiter.api.Assertions.*;

import com.example.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class InvoiceServiceTest {
    private static InvoiceService invoiceService;
    private static RideRepository rideRepository;

    @BeforeAll
    public static void setup() {
        rideRepository = new RideRepository();
        invoiceService = new InvoiceService(rideRepository);
    }

    @Test
    public void givenUserId_ShouldReturnInvoice() {
        String userId = "user1";
        List<Ride> rides = Arrays.asList(new Ride(2.0, 5, RideType.NORMAL), new Ride(0.5, 3, RideType.PREMIUM));
        rideRepository.addRides(userId, rides);

        Invoice invoice = invoiceService.getInvoiceForUser(userId);

        assertNotNull(invoice);
        assertEquals(2, invoice.getTotalRides());
    }

    @Test
    public void givenInvalidUserId_ShouldReturnNull() {
        Invoice invoice = invoiceService.getInvoiceForUser("invalidUser");
        assertNull(invoice);
    }

}