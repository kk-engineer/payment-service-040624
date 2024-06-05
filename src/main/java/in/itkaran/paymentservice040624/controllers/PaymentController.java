package in.itkaran.paymentservice040624.controllers;

import com.stripe.exception.StripeException;
import in.itkaran.paymentservice040624.dtos.InitiatePaymentDto;
import in.itkaran.paymentservice040624.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public ResponseEntity<String> initiatePayment(@RequestBody InitiatePaymentDto requestDto)
    throws StripeException {
        String paymentLink = paymentService.generatePaymentLink(requestDto.getOrderId(), requestDto.getAmount());
        return ResponseEntity.ok(paymentLink);
    }
}
