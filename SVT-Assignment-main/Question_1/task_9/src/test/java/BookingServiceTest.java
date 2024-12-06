import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class BookingServiceTest {

    @Mock
    private PaymentService paymentService; // Mock the dependency

    @InjectMocks
    private BookingService bookingService; // Inject the mock into the service

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks and inject them
    }

    @Test
    @DisplayName("Should call processPayment when booking a service")
    public void testBookService_callsProcessPayment() {
        // Arrange
        double amount = 120.0;

        // Act
        bookingService.bookService(amount);

        // Assert
        verify(paymentService, times(1)).processPayment(amount); // Verify the interaction
    }
    
}
