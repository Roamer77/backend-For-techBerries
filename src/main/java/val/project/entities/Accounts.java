package val.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String login;
    private String password;
    private String userName;
    private String userSecondName;
    private  String userPhoneNumber;
    private Integer isBlocked;
    private Integer numberOfOrders;
    private Integer cashBalance; //скорее всего в базе не стои тэто хранить .Если будет время придумать другой способ
    private String cityName;
    private String countryName;
    private  Integer personalDiscount;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "account")
    private List<UserOrder> userOrders =new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
  //  @JoinTable(name="USER_FAVORITE_BRANDS",joinColumns = @JoinColumn(name = "favoriteBrands"), inverseJoinColumns = @JoinColumn(name = "ID"))
    private List<Brand> favoriteBrands =new ArrayList<>();//чекнуть как праельно

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Role role;

    public Accounts() {
    }

    public Accounts(String login, String password, String userPhoneNumber) {
        this.login = login;
        this.password = password;
        this.userPhoneNumber = userPhoneNumber;
    }

    public Long getId() {
        return id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public Integer getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(Integer cashBalance) {
        this.cashBalance = cashBalance;
    }

    public void setPersonalDiscount(Integer personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public Integer getPersonalDiscount() {
        return personalDiscount;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


    public List<Brand> getFavoriteBrands() {
        return favoriteBrands;
    }

    public void setFavoriteBrands(List<Brand> favoriteBrands) {
        this.favoriteBrands = favoriteBrands;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
