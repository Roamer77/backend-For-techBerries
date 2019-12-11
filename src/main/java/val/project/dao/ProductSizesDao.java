package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import val.project.entities.ProductSize;

import java.util.List;

public interface ProductSizesDao extends JpaRepository<ProductSize,Long> {
    ProductSize getProductSizeBySizeValue(int sizeValue);

    @Query("select p from ProductSize p where p.location= :location ")
    List<ProductSize> getAllByLocation(@Param("location") String locationShortName);
}
