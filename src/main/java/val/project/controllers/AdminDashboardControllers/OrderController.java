package val.project.controllers.AdminDashboardControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import val.project.entities.UserOrder;
import val.project.services.AdminDashboardServices.OrderService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orderList")
    public List<UserOrder> getOrderList(@RequestParam int pageNumber) {
          return   orderService.getListOfOrders(pageNumber);
    }

    @GetMapping("/test1")
    public List<UserOrder> test(){
        return orderService.test();
    }
}
