package val.project.dao.daosForTestTables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import val.project.entities.testEntites.Alian;

public interface AlianDao extends JpaRepository<Alian,Integer> {
    Alian findById(int id);
}
