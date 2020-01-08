package val.project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/autharization")
public class АuthorizationController {

    /* @PostMapping ("/auth")
     public int getUserAuthInfo(@RequestBody String data){
         System.out.println("Данные для авторизации пользователя :"+data);
         //если пользователь авторизован отправить ему нужный куд. Потом определить какой
         return 666;
     }*/
    private Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @GetMapping("/logoutSuccess")
    private String checkAuthorization(HttpServletRequest request, HttpServletResponse response) {

        return "logoutSuccess";
    }

    @PostMapping("/auth")
    public int UserAuthInfo() {

        //если пользователь авторизован отправить ему нужный куд. Потом определить какой
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            System.out.println(authentication.getName() + " авторизовался");
        }
        return 777;
    }

    @GetMapping("/showInfo")
    private String showInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            System.out.println(authentication.getName() + " авторизовался");
        } else {
            System.out.println(authentication.getName() + "не авторизовался");
        }
        return authentication.getName();

    }

}
