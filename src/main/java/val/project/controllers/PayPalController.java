package val.project.controllers;

import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import val.project.dao.PaymentDetailsDao;
import val.project.entities.PaymentDetails;
import val.project.payment_integration.PayPalClient;
import val.project.utils.TimeConverter;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PayPalController {

    @Autowired
    private PayPalClient payPalClient;
    @Autowired
    private PaymentDetailsDao paymentDetailsDao;

    @GetMapping("/make")
    public RedirectView makePayment(@RequestParam("sum") String sum) {
        Map<String, Object> data = payPalClient.createPayment(sum);
        String redirectUrl = (String) data.get("redirect_url");
        return payPalClient.doRedirect(redirectUrl);
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "Canceled";
    }

    @GetMapping("/success")
    public String conserved(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerID) {
        Map<String, Object> tmp = payPalClient.comparePayment(paymentId, payerID);
        System.out.println("Ответ от сервера paypal: " + tmp.entrySet());
        Payment payment = (Payment) tmp.get("payment");

        PaymentDetails paymentDetails = new PaymentDetails();
        TimeConverter timeConverter = new TimeConverter();
        long startTime = timeConverter.getDateInTimestap(payment.getCreateTime());
        long endTime = timeConverter.getDateInTimestap(payment.getUpdateTime());


        paymentDetails.setStatus((String) tmp.get("status"));
        paymentDetails.setStartTime(startTime);
        paymentDetails.setEndTime(endTime);
        paymentDetails.setPayeeEmail( payment.getTransactions().get(0).getPayee().getEmail());
        paymentDetails.setUserName(payment.getPayer().getPayerInfo().getFirstName());
        paymentDetails.setUserSurname(payment.getPayer().getPayerInfo().getLastName());
        paymentDetails.setUserPayPalEmail(payment.getPayer().getPayerInfo().getEmail());
        paymentDetails.setMerchantId(payment.getTransactions().get(0).getPayee().getMerchantId());
        paymentDetails.setTotalSum(Double.valueOf( payment.getTransactions().get(0).getAmount().getTotal()));
        System.out.println("PaymentDetails: "+paymentDetails.toString());
        paymentDetailsDao.save(paymentDetails);
        paymentDetailsDao.flush();



        return "Conserved!";
    }
}
