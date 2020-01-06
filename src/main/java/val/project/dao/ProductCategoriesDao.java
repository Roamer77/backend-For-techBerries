package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import val.project.entities.ProductCategories;

import java.util.List;

public interface ProductCategoriesDao extends JpaRepository<ProductCategories,Long> {

    ProductCategories getAllByCategoryName(String categoryName);
    ProductCategories getById(long id);
}
