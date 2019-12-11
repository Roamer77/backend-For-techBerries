package val.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import val.project.dao.ProductCategoriesDao;
import val.project.entities.ProductCategories;
import val.project.seviceInterfaces.ProductCategory;

public class ProductCategoriesService implements ProductCategory {
    @Autowired
    ProductCategoriesDao productCategoriesDao;



    @Override
    public ProductCategories getCategoryByName(String name) {
        return productCategoriesDao.getAllByCategoryName(name);
    }
}
