package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import val.project.entities.Accounts;

public interface AccountDao extends JpaRepository<Accounts,Long> {
    Accounts findAllById(long id);
}
