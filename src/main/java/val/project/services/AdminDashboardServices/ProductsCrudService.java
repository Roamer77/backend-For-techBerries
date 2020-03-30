package val.project.services.AdminDashboardServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import val.project.DTO.forProductCRUDops.ProductForAdding;
import val.project.DTO.forProductCRUDops.UpdatedProductInfo;
import val.project.dao.ProductDao;
import val.project.entities.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsCrudService {
    int  productPerPage=10;
    @Autowired
    ProductDao productDao;
    @Autowired
    AddNewProductService addNewProductService;

    public List<Product> getListOfProductsByPage(int pageNumber){
        return productDao.findAll(PageRequest.of(pageNumber,productPerPage)).toList();
    }
    public List<Product> findProductByName(String name){
        return productDao.findAllByNameContainingIgnoreCase(name);
    }
    public void deleteProductById(long id){
        productDao.deleteById(id);
    }

    public void saveProduct(ProductForAdding newProduct){
        addNewProductService.addNewProductToDB(newProduct);
    }


    private void updateProduct(UpdatedProductInfo newProductInfo){
       long id = newProductInfo.getId();
      Optional<Product> product = productDao.findById(id);
    }
}
