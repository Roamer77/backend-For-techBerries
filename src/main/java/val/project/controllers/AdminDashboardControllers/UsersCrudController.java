package val.project.controllers.AdminDashboardControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import val.project.DTO.LimitedAccountInfo;
import val.project.entities.Accounts;
import val.project.entities.Manager;
import val.project.services.AdminDashboardServices.UserCrudService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/userCrudOperations")
public class UsersCrudController {

    @Autowired
    UserCrudService userCrudService;

    @GetMapping("/getListOfAccounts")
    public List<LimitedAccountInfo> getListOfAccountsByPage(int pageNumber){
        return userCrudService.getListOfAccountsByPage(pageNumber);
    }

    @GetMapping("/getListOfManagers")
    public List<Manager> getListOfManagersByPage(int pageNumber){
        return userCrudService.getListOfManagersByPage(pageNumber);
    }
}
