public class OrderService {
    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public boolean placeOrder(String item, int quantity) {
        // Ensure the quantity is greater than zero
        if (quantity <= 0) return false;

        // Call the ship method on the shipping service
        return shippingService.ship(item, quantity);
    }
}

interface ShippingService {
    boolean ship(String item, int quantity);
}