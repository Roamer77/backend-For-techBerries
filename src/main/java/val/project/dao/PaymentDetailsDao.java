package val.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import val.project.entities.PaymentDetails;

public interface PaymentDetailsDao extends JpaRepository<PaymentDetails,Long> {

}
