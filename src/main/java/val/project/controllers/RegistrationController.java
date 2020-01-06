package val.project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import val.project.DTO.UserInfoFromClient;
import val.project.services.AccountCRUDService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    AccountCRUDService accountCRUDService;

    @PostMapping("/register")
    private  void  showRegisteredUserInfo(@RequestBody String data){
        System.out.println("Данные о регестрируемом пользователе ");
        System.out.println("Данные: "+data);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            UserInfoFromClient userInfo=objectMapper.readValue(data,UserInfoFromClient.class);
            if(userInfo!=null){
                accountCRUDService.saveUserInDataBase(userInfo.getUserLogin(),userInfo.getUserPassword(),userInfo.getUserPhoneNumber());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/encrypt")
    private String doEncrypt(){
        String pass="password";
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(pass);
    }
}
