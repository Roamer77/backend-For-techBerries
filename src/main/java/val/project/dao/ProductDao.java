package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import val.project.entities.Product;
import val.project.entities.ProductSize;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Long> {

    Product findAllById(long id);
    Product findAllByName(String productName);

    @Query("select p from Product p where p.name= :productName")
    Product myFindProductByName(@Param("productName") String productName);
}
