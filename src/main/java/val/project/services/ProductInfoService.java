package val.project.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import val.project.DTO.ProductDescriptionToClient;
import val.project.dao.ProductDao;
import val.project.entities.Product;
import val.project.entities.ProductDescription;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class ProductInfoService {
    private Logger logger=Logger.getLogger(this.getClass().getName());
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

    public  ProductDescriptionToClient getProductDescriptionByName(String productName){
        product=productDao.myFindProductByName(productName);
        ProductDescriptionToClient descriptionToClient=new ProductDescriptionToClient();
        ProductDescription  description=product.getProductDescription();

        descriptionToClient.setCost(product.getCost());
        descriptionToClient.setId((int) product.getId());
        descriptionToClient.setSeason(description.getSeason());
        descriptionToClient.setSex(description.getSex());
        descriptionToClient.setSoleHeight(description.getSoleHeight());
        descriptionToClient.setSoleMaterial(description.getSoleMaterial());
        return descriptionToClient;
    }

    public List<Product> findProductsByName(String name){
        return productDao.findAllByNameContainingIgnoreCase(name);
    }

}
