import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Test
    public void testPlaceOrder_ValidShipment() {
        // Mock the ShippingService
        ShippingService shippingService = Mockito.mock(ShippingService.class);

        // Stub the ship method to return true for valid shipments
        when(shippingService.ship("validItem", 10)).thenReturn(true);

        // Create the OrderService with the mocked ShippingService
        OrderService orderService = new OrderService(shippingService);

        // Place a valid order
        boolean result = orderService.placeOrder("validItem", 10);

        // Verify the ship method was called with correct parameters
        assertTrue(result);
        verify(shippingService).ship("validItem", 10);
    }

    @Test
    public void testPlaceOrder_InvalidShipment() {
        // Mock the ShippingService
        ShippingService shippingService = Mockito.mock(ShippingService.class);

        // Stub the ship method to return false for invalid shipments
        when(shippingService.ship("invalidItem", 0)).thenReturn(false);

        // Create the OrderService with the mocked ShippingService
        OrderService orderService = new OrderService(shippingService);

        // Place an invalid order
        boolean result = orderService.placeOrder("invalidItem", 0);

        // Verify the ship method was not called since quantity is invalid
        assertFalse(result);
        verify(shippingService, never()).ship(anyString(), eq(0));
    }
}