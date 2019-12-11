package val.project.forCastomIntegfaces;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import val.project.entities.Product;

public interface MyStoredProcedurCaller extends CrudRepository<Product,Long> {
    @Procedure(name="changeCostForProduct")
    void doChangeCostForProduct(@Param("my_id") long id, @Param("new_Const") int newCost);
}
