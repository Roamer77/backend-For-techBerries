package val.project.DTO;

public class LimitedAccountInfo {
    private Long id;
    private String login;
    private String userName;
    private String userSecondName;
    private String userPhoneNumber;
    private Integer isBlocked;
    private String mail;

    public LimitedAccountInfo() {
    }

    public LimitedAccountInfo(Long id, String login, String userName, String userSecondName, String userPhoneNumber, Integer isBlocked, String mail) {
        this.id = id;
        this.login = login;
        this.userName = userName;
        this.userSecondName = userSecondName;
        this.userPhoneNumber = userPhoneNumber;
        this.isBlocked = isBlocked;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSecondName() {
        return userSecondName;
    }

    public void setUserSecondName(String userSecondName) {
        this.userSecondName = userSecondName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Integer getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Integer isBlocked) {
        this.isBlocked = isBlocked;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "LimitedAccountInfo{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", userName='" + userName + '\'' +
                ", userSecondName='" + userSecondName + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", isBlocked=" + isBlocked +
                ", mail='" + mail + '\'' +
                '}';
    }
}
