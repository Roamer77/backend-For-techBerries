package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import val.project.entities.ProductDescription;

public interface ProductDescriptionDao extends JpaRepository<ProductDescription,Long> {
    ProductDescription getById(Long id);
}
