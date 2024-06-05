package in.itkaran.paymentservice040624.services.paymentgateways;

import in.itkaran.paymentservice040624.services.PaymentService;
import org.springframework.stereotype.Service;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Service("razorpay")
public class RazorPayPaymentService implements PaymentGateway {
    private final RazorpayClient razorpay;

    public RazorPayPaymentService(RazorpayClient razorpay) {
        this.razorpay = razorpay;
    }

    public String createPaymentLink(String orderId, Long amount)
            throws  RazorpayException{
        // Source: https://razorpay.com/docs/api/payments/payment-links/create-standard/
        //Order order = orderService.getOrder(orderId)
        //amount = order.getAmount();
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount); // 10.00
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", 1716601690);
        paymentLinkRequest.put("reference_id", orderId);
        paymentLinkRequest.put("description","Payment for order id: " + orderId.toString());
        JSONObject customer = new JSONObject();
        customer.put("name","+918007775284");
        customer.put("contact","Kumar Karan");
        customer.put("email","kumar.karan_1@scaler.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Scaler");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com/academy/instructor-dashboard/");
        paymentLinkRequest.put("callback_method","get");

        // Create payment link
        PaymentLink paymentLink = razorpay.paymentLink.create(paymentLinkRequest);
        return paymentLink.toString();
    }
}
