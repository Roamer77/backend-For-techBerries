package val.project.controllers.AdminDashboardControllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import val.project.DTO.forProductCRUDops.ProductForAdding;
import val.project.DTO.forProductCRUDops.UpdatedProductInfo;
import val.project.entities.Product;
import val.project.services.AdminDashboardServices.ProductsCrudService;
import val.project.services.ImageConvertingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/productsCrudOperations")
public class ProductsCrudController {

    private ProductsCrudService productsCrudService;

    private ImageConvertingService imageConvertingService;


    @Autowired
    public ProductsCrudController(ProductsCrudService productsCrudService, ImageConvertingService imageConvertingService) {
        this.productsCrudService = productsCrudService;
        this.imageConvertingService = imageConvertingService;
    }

    @GetMapping("/getListOfProducts")
    public List<Product> getListOfProducts(int pageNumber){
        return productsCrudService.getListOfProductsByPage(pageNumber);
    }


    @PostMapping("/changeProductInfo" )
    public void makeProductInfoChanges(@RequestBody UpdatedProductInfo dataFromClient){
        System.out.println("--------------------------------------------");
        System.out.println("  ");
        System.out.println("New product info from Admin: "+dataFromClient);
        System.out.println("  ");
        System.out.println("--------------------------------------------");
    }
    @GetMapping("/findByName")
    public List<Product> getProductsByName(@RequestParam String name){
        List<Product> products=productsCrudService.findProductByName(name);
        if(products!=null){
            return products;
        }
        return new ArrayList<>();
    }

    @PostMapping("/deleteProductById")
    public void deleteProductById(@RequestBody long id){
        System.out.println("Будет удалён продукт с id = " +id );
    }

    @PostMapping("/addNewProduct")
    public void addNewProduct(@RequestBody ProductForAdding newProduct ){
        System.out.println("NEW PRODUCT:   "+newProduct);
        productsCrudService.saveProduct(newProduct);
    }
}
