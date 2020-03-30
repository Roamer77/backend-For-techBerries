package val.project.services.AdminDashboardServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import val.project.DTO.LimitedAccountInfo;
import val.project.dao.AccountDao;
import val.project.dao.ManagerDao;
import val.project.entities.Accounts;
import val.project.entities.Manager;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCrudService {
    int itemsPerPage = 10;

    @Autowired
    AccountDao accountDao;

    @Autowired
    ManagerDao managerDao;

    public List<LimitedAccountInfo> getListOfAccountsByPage(int pageNumber) {
        List<Accounts> accounts = accountDao.findAll(PageRequest.of(pageNumber, itemsPerPage)).toList();
        List<LimitedAccountInfo> accountInfos = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            accountInfos.add(limitAccountInfo(accounts.get(i)));
        }

        return accountInfos;
    }

    public List<Manager> getListOfManagersByPage(int pageNumber) {
        return managerDao.findAll(PageRequest.of(pageNumber, itemsPerPage)).toList();
    }

// лучше будет написать кастомный сериализатор который не будет учитывать необходимые поля
    //пока оставлю так
    private LimitedAccountInfo limitAccountInfo(Accounts account) {

        LimitedAccountInfo limitedAccountInfo = new LimitedAccountInfo();

        limitedAccountInfo.setId( account.getId() );
        limitedAccountInfo.setLogin( account.getLogin() );
        limitedAccountInfo.setMail( account.getMail() );
        limitedAccountInfo.setIsBlocked( account.getIsBlocked() );
        limitedAccountInfo.setUserName( account.getUserName() );
        limitedAccountInfo.setUserSecondName( account.getUserSecondName() );
        limitedAccountInfo.setUserPhoneNumber( account.getUserPhoneNumber() );

        return limitedAccountInfo;
    }
}
