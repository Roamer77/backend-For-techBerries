package val.project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import val.project.dao.ProductDao;
import val.project.dao.daosForTestTables.AlianDao;
import val.project.entities.Product;
import val.project.entities.testEntites.Alian;
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
    @GetMapping("/productDescription")
    public String getProductDescription(@RequestParam String productName){
        String res=productInfoService.getProductDescriptionByName(productName);
        return res;
    }
}
