package in.itkaran.paymentservice040624.services.paymentgateways;

import in.itkaran.paymentservice040624.services.PaymentService;
import org.springframework.stereotype.Service;

@Service("razorpay")
public class RazorPayPaymentService implements PaymentGateway {

    public String createPaymentLink(String orderId, Long amount) {
        return null;
    }
}
