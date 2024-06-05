package in.itkaran.paymentservice040624.advices;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(StripeException.class)
    public ResponseEntity<String> handleStripeException(StripeException stripeException) {
        String msg = "Error in Stripe payment, reason: " + stripeException.getMessage();
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RazorpayException.class)
    public ResponseEntity<String> handleRazorPayException(RazorpayException razorpayException) {
        String msg = "Error in RazorPay payment, reason: " + razorpayException.getMessage(); ;
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

}
