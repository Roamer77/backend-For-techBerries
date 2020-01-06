package val.project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import val.project.DTO.OrderInfoFromClient;
import val.project.services.OrderMakeService;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/order")
public class OrderMakeController {

    @Autowired
    OrderMakeService orderMakeService;

    private ObjectMapper objectMapper;

    @PostMapping("/makeOrder")
    public String makeOrder(@RequestBody OrderInfoFromClient orderInfo) {
        System.out.println("Информация о заказе: " + orderInfo);

        orderMakeService.saveOrder(orderInfo);

        objectMapper = new ObjectMapper();
        try {
            String res = objectMapper.writeValueAsString("Сделан заказик");
            return res;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Пусто";
    }

    @GetMapping("/test")
    public  String test(){
        return "test";
    }

}
