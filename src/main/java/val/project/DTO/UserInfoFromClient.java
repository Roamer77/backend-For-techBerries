package val.project.DTO;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserInfoFromClient {
    private String userLogin;
    private  String userPassword;
    private  String userPhoneNumber;
    private BCryptPasswordEncoder passwordEncoder;

    public UserInfoFromClient() {
    }

    public UserInfoFromClient(String userLogin, String userPassword, String userPhoneNumber) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;

    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        passwordEncoder=new BCryptPasswordEncoder();
        return passwordEncoder.encode(userPassword);
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }
}
