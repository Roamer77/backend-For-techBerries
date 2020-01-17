package val.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import val.project.DTO.ProductDescriptionToClient;
import val.project.dao.ProductDao;
import val.project.entities.Product;
import val.project.entities.ProductDescription;
import val.project.services.ProductInfoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productInfo")
public class InfoAboutProductController {

    @Autowired
    ProductDao productDao;
    @Autowired
    ProductInfoService productInfoService;
    @GetMapping("/info")
    public String getProductInfo(@RequestParam String productName){
        String res= productInfoService.getInfoAboutService(productName);

        return res;
    }
    @GetMapping(value = "/productDescription",produces =  MediaType.APPLICATION_JSON_VALUE)
    public ProductDescriptionToClient getProductDescription(@RequestParam String productName){
        ProductDescriptionToClient description= productInfoService.getProductDescriptionByName(productName);
        System.out.println("Я уже отправил инфу продукте");
        if(description!=null){
            return description;
        }
        return null;
    }

    @GetMapping("/getProductsByName")
    public List<Product> getProductsByName(@RequestParam String name){
        List<Product> products=productInfoService.findProductsByName(name);
        if(products!=null){
            return products;
        }
        return new ArrayList<>();
    }
    @GetMapping("/test")
    public List<Product> filterByCategoryAndSex(@RequestParam String sex,Long categotyId){
        List<Product> testList= productDao.customfindAll(sex,categotyId);
        testList.forEach(s-> System.out.println("id= "+s.getId()+" name= "+s.getName()+" sex= "+s.getProductDescription().getSex()));

        return new ArrayList<>();
    }
}
