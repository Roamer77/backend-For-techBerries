package val.project.dao;

import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import val.project.entities.UserOrder;

public interface UserOrderDao extends JpaRepository<UserOrder,Long> {
    UserOrder findById(long id);
}
