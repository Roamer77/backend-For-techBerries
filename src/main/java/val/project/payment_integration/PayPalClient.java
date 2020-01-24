package val.project.payment_integration;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PayPalClient {
    private  String clientID="ARN3D7Rggp19nejDzLT_Wd_7ciEDyQDpIFTJ6uO3Md1te7yqr7uhKVPfFzB2Zl1sPmZCW5sgZZ-Bi1Kj";
    private String clientSecret="EA2g64NMzK6v7rqIsZmrmz7qab6r8xLItLaQXKKi_5Jl10UYp4n7PCTghhirZUr_QdAbGcQIeTD6jbRb";

    public Map<String,Object> createPayment(String sum){
        Map<String ,Object> response=new HashMap<>();

        Amount amount=new Amount();
        amount.setCurrency("USD");
        amount.setTotal(sum);

        Transaction transaction=new Transaction();
        transaction.setAmount(amount);

        List<Transaction> transactions=new ArrayList<>();
        transactions.add(transaction);

        Payer payer=new Payer();
        payer.setPaymentMethod("paypal");

        Payment payment=new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        RedirectUrls redirectUrls=new RedirectUrls();
        redirectUrls.setCancelUrl("http://192.168.59.1:8080/payment/cancel");
        redirectUrls.setReturnUrl("http://192.168.59.1:8080/payment/success");

        payment.setRedirectUrls(redirectUrls);

        Payment createdPayment;
        try {
            String redirectUrl = "";
            APIContext context = new APIContext(clientID, clientSecret, "sandbox");
            createdPayment = payment.create(context);
            if(createdPayment!=null){
                List<Links> links = createdPayment.getLinks();
                for (Links link:links) {
                    if(link.getRel().equals("approval_url")){
                        redirectUrl = link.getHref();
                        break;
                    }
                }
                response.put("status", "success");
                response.put("redirect_url", redirectUrl);
            }
        } catch (PayPalRESTException e) {
            System.out.println("Error happened during payment creation!");
        }
        return response;
    }

    public Map<String,Object> comparePayment(String paymentId,String payerId){
        Map<String ,Object > response=new HashMap<>();
        Payment payment=new Payment();
        payment.setId(paymentId);

        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);
        try {
            APIContext context = new APIContext(clientID, clientSecret, "sandbox");
            Payment createdPayment = payment.execute(context, paymentExecution);
            if(createdPayment!=null){
                response.put("status", "success");
                response.put("payment", createdPayment);
            }
        } catch (PayPalRESTException e) {
            System.err.println(e.getDetails());
        }
        return response;
    }

    public RedirectView doRedirect(String redirectUrl){
        return new RedirectView(redirectUrl);
    }
}
