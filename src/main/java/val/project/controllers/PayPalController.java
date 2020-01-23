package val.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import val.project.payment_integration.PayPalClient;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PayPalController {

    @Autowired
    private PayPalClient payPalClient;

    @GetMapping("/make")
    public RedirectView makePayment(@RequestParam("sum") String sum){
        Map<String,Object> data=payPalClient.createPayment(sum);
        String redirectUrl=(String) data.get("redirect_url");
        return payPalClient.doRedirect(redirectUrl);
    }

    @GetMapping("/complete")
    public Map<String, Object> completePayment(HttpServletRequest request){
        return payPalClient.comparePayment(request);
    }

    @GetMapping("/cancel")
    public String cancel(){
        return "Canceled";
    }

    @GetMapping
    public String conserved(){
        return "Conserved!";
    }
}
