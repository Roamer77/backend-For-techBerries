package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import val.project.entities.Manager;

public interface ManagerDao extends JpaRepository<Manager, Integer> {

}
