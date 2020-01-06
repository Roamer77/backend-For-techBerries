package val.project.dao;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import val.project.entities.Advertising;

import java.util.List;

public interface AdvertisingDAO extends JpaRepository<Advertising,Integer> {
    List<Advertising> findAll();
}
