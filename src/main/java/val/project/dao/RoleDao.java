package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import val.project.entities.Role;

public interface RoleDao extends JpaRepository<Role,Integer> {
    Role getRoleById(Integer id);
}
