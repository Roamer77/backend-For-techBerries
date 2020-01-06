package val.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import val.project.dao.AccountDao;
import val.project.dao.RoleDao;
import val.project.entities.Accounts;
import val.project.entities.Role;

import java.util.logging.Logger;

@Service
public class AccountCRUDService {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private RoleDao roleDao;

    private Accounts newAccount;


    public void saveUserInDataBase(String login, String password, String phoneNamber) {
        Role userRole = roleDao.getRoleById(2);

        newAccount = new Accounts(login, password, phoneNamber);
        newAccount.setIsBlocked(1);
        newAccount.setRole(userRole);
        accountDao.save(newAccount);
        accountDao.flush();

        logger.info("Новый аккаунт зарегестрирован");
    }

    public Accounts getCurrentSessionAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            System.out.println(authentication.getName() + " авторизовался");

            String login = authentication.getName();

            return accountDao.findByLogin(login);
        } else {
            System.out.println(authentication.getName() + "не авторизовался");
        }
        return null;
    }


}
