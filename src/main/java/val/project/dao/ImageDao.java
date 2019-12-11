package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import val.project.entities.Images;

public interface ImageDao extends JpaRepository<Images,Long> {

    Images getById(Long id);
}
