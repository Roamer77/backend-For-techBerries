package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import val.project.entities.Brand;

public interface BrandDao extends JpaRepository<Brand,Long> {
}
