import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void testProcessPaymentIsCalled() {
        String bookingId = "12345";


        bookingService.bookService(bookingId);


        verify(paymentService, times(1)).processPayment(bookingId);
    }
}

//Question no-9 test class
