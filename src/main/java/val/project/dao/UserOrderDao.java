package val.project.dao;

import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import val.project.entities.UserOrder;


import java.util.List;

@Repository
public interface UserOrderDao extends JpaRepository<UserOrder,Long> {
    UserOrder findById(long id);
    List<UserOrder> findAll();


}
