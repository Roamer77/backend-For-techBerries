package val.project.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import val.project.dao.ProductDao;
import val.project.entities.Product;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductInfoService {
    @Autowired
    ProductDao productDao;
    private Product product;
    private ObjectMapper objectMapper;

    public  String getInfoAboutService(String productName){
        product=productDao.myFindProductByName(productName);
        if(product!=null){
            objectMapper=new ObjectMapper();
            Map<String,String> data=new HashMap<>();

            data.put("name",product.getName());
            data.put("cost",String.valueOf(product.getCost()));
            data.put("average Rating",String.valueOf(product.getAverageRating()));
            data.put("vendor code",String.valueOf(product.getVendorCode()));
            data.put("productCategory",product.getProductCategories().getCategoryName());

            try {
                String productInfo= objectMapper.writeValueAsString(data);
                return productInfo;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public  String getProductDescriptionByName(String productName){
        product=productDao.myFindProductByName(productName);
        objectMapper=new ObjectMapper();
        try {
            String productDescription= objectMapper.writeValueAsString(product.getProductDescription());
            return productDescription;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
