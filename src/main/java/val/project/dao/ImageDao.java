package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import val.project.entities.Images;

import java.util.List;

public interface ImageDao extends JpaRepository<Images,Long> {

    Images getById(Long id);

   /* @Query("select SMALL_SIZE_IMAGE from IMAGES join PRODUCT P on IMAGES.ID = P.IMAGES_ID where PRODUCT_CATEGORIES_ID =: category ")
    List<Images> getSmallImagesByCategory(@Param("category") int category);*/
}
