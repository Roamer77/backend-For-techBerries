package val.project.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import val.project.DTO.OrderInfoFromClient;
import val.project.dao.AccountDao;
import val.project.dao.MailQueueDao;
import val.project.dao.ProductDao;
import val.project.dao.UserOrderDao;
import val.project.entities.Accounts;
import val.project.entities.MailQueue;
import val.project.entities.Product;
import val.project.entities.UserOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class OrderMakeService {
    @Autowired
    ProductDao productDao;
    @Autowired
    UserOrderDao userOrderDao;
    @Autowired
    AccountCRUDService accountCRUDService;

    @Autowired
    MailQueueDao mailQueueDao;

    private Logger logger=Logger.getLogger(this.getClass().getName());

    private ObjectMapper objectMapper;
    private UserOrder tmpOrder;

    public void saveOrder(OrderInfoFromClient orderInfoFromClient)  {
        System.out.println("Заказ: "+orderInfoFromClient.toString());

        List<Product> productsInOrder=productDao.findAllProductsByListOfId(orderInfoFromClient.getProductsIDs());

        Accounts userAccount=accountCRUDService.getCurrentSessionAccount();
        String typeOfDelivery =String.valueOf(orderInfoFromClient.getDeliveryType());
        String typeOfPayment=String.valueOf(orderInfoFromClient.getPaymentType());
        Integer fullPrice=orderInfoFromClient.getPrice();
        String address=orderInfoFromClient.getAddress();

        UserOrder order=new UserOrder();
        order.setProducts(productsInOrder);
        order.setTypeOfDelivery(typeOfDelivery);
        order.setTypeOfPayment(typeOfPayment);
        order.setAddressForCourier(address);
        order.setAccount(userAccount);
        order.setFullPrice(fullPrice);
        logger.info("\n Заказ который сейчас сохранился "+order.toString());
        userOrderDao.save(order);
        userOrderDao.flush();
        addOderToMailQueue(order);
    }

    private  void addOderToMailQueue(UserOrder userOrder){
        MailQueue mail=new MailQueue();
        mail.setMainStatus(2);
        mail.setUserOrder(userOrder);
        mailQueueDao.save(mail);
        mailQueueDao.flush();
    }
}
