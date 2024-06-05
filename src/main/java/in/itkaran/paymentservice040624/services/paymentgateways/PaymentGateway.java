package in.itkaran.paymentservice040624.services.paymentgateways;

import com.razorpay.RazorpayException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;

public interface PaymentGateway {

    public String createPaymentLink(String orderId, Long amount) throws StripeException, RazorpayException;
}
