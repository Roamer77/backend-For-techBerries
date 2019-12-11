package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import val.project.entities.Review;

public interface ReviewDao extends JpaRepository<Review,Long> {
    Review findAllById(long id);
}
