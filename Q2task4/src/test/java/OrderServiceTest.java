import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private ShippingService shippingService; // Mock dependency

    @InjectMocks
    private OrderService orderService; // Class under test

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testPlaceOrderCallsShip() {
        // Arrange
        String item = "Laptop";
        int quantity = 1;

        when(shippingService.ship(item, quantity)).thenReturn(true); // Stub

        // Act
        boolean result = orderService.placeOrder(item, quantity);

        // Assert
        assertTrue(result, "Order should be successful");
        verify(shippingService).ship(item, quantity); // Verify ship() is called
    }
}
