class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public boolean placeOrder(String item, int quantity) {
        if (quantity <= 0) {
            return false;
        }
        return shippingService.ship(item, quantity);
    }
}
