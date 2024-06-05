package in.itkaran.paymentservice040624.services.paymentgateways;

import com.stripe.exception.StripeException;

public interface PaymentGateway {

    public String createPaymentLink(String orderId, Long amount) throws StripeException;
}
