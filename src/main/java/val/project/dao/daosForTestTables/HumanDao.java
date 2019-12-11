package val.project.dao.daosForTestTables;

import org.springframework.data.jpa.repository.JpaRepository;
import val.project.entities.testEntites.Human;

public interface HumanDao extends JpaRepository<Human,Long> {
}
