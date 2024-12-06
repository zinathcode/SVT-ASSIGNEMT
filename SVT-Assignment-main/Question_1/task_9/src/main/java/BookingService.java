public class BookingService {
     private final PaymentService paymentService;
 
     public BookingService(PaymentService paymentService) {
         this.paymentService = paymentService;
     }
 
     public void bookService(double amount) {
         paymentService.processPayment(amount);
     }
 }
 