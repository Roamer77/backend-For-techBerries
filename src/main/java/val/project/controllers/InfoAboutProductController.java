package val.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import val.project.services.ProductInfoService;

@RestController
@RequestMapping("/productInfo")
public class InfoAboutProductController {

    @Autowired
    ProductInfoService productInfoService;
    @GetMapping("/info")
    public String getProductInfo(@RequestParam String productName){
        String res= productInfoService.getInfoAboutService(productName);

        return res;
    }
    @GetMapping(value = "/productDescription",produces =  MediaType.APPLICATION_JSON_VALUE)
    public String getProductDescription(@RequestParam String productName){
        String res=productInfoService.getProductDescriptionByName(productName);
        System.out.println("Я уже отправил инфу продукте");

        return res;
    }
}
