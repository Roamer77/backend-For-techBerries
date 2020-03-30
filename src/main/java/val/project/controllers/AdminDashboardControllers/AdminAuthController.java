package val.project.controllers.AdminDashboardControllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import val.project.DTO.AdminInfo;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminAuthController {


    @PostMapping("/login")
    public  Integer tryLogin(@RequestBody AdminInfo adminInfo){
        System.out.println(adminInfo.toString());
        if(adminInfo.getPassword().equals("admin")&&adminInfo.getLogin().equals("admin")){
            return 2;
        }
        return 1;
    }

    @GetMapping("/test")
    public String test(){
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String s= objectMapper.writeValueAsString("Test");
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Test";
    }
}
