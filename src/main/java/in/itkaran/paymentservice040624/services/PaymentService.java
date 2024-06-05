package in.itkaran.paymentservice040624.services;

import com.stripe.exception.StripeException;
import in.itkaran.paymentservice040624.services.paymentgateways.PaymentGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentGateway paymentGateway;

    PaymentService(@Qualifier("stripe") PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String generatePaymentLink(String orderId, Long amount)
    throws StripeException {
        return paymentGateway.createPaymentLink(orderId, amount);
    }
}
