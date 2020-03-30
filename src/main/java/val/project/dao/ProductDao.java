package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import val.project.entities.Product;
import val.project.entities.ProductCategories;

import java.util.Collection;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    Product findAllById(long id);

    List<Product> findAllByName(String productName);

    @Query("select p from Product p where p.name= :productName")
    Product myFindProductByName(@Param("productName") String productName);

    List<Product> findAllByProductCategories(ProductCategories productCategories);

    @Query("select p from Product p  where id in :list")
    List<Product> findAllProductsByListOfId(@Param("list") Collection<Long> idList);

    List<Product> findAllByNameContainingIgnoreCase(String name);

    @Query("select p from Product p inner join ProductDescription pd on p.productDescription.id=pd.id where pd.sex= :sex and p.productCategories.id=:categoryId")
    List<Product> customfindAll(@Param("sex") String sex,@Param("categoryId") Long categoryId);
}
