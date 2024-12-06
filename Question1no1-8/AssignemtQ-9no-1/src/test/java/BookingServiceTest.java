import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class) // Enable Mockito extension for JUnit 5
class BookingServiceTest {

    @Mock
    private PaymentService paymentService; // Mock PaymentService

    @InjectMocks
    private BookingService bookingService; // Inject mocked PaymentService into BookingService

    @Test
    void testProcessPaymentIsCalled() {
        String bookingId = "12345"; // Example booking ID

        // Call the method to test
        bookingService.bookService(bookingId);

        // Verify that the processPayment method was called once with the given booking ID
        verify(paymentService, times(1)).processPayment(bookingId);
    }
}
