package val.project.services.AdminDashboardServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import val.project.dao.UserOrderDao;
import val.project.entities.UserOrder;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private UserOrderDao userOrderDao;

    public List<UserOrder> getListOfOrders(int pageNumber){
        Page<UserOrder> result = userOrderDao.findAll(PageRequest.of(pageNumber,10));
        return  result.toList();
    }

    public  List<UserOrder> test(){
        return userOrderDao.findAll();
    }


}
