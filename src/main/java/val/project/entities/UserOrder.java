package val.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String TypeOfDelivery;
    private String addressForCourier;
    private String TypeOfPayment;
    private Integer fullPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private Accounts account;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> products;

    @JsonIgnore
    @OneToOne(mappedBy = "userOrder",fetch = FetchType.LAZY,optional = false)
    private MailQueue orderMail;

    public UserOrder() {
    }

    public Integer getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Integer fullPrice) {
        this.fullPrice = fullPrice;
    }

    public MailQueue getOrderMail() {
        return orderMail;
    }

    public void setOrderMail(MailQueue orderMail) {
        this.orderMail = orderMail;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTypeOfDelivery() {
        return TypeOfDelivery;
    }

    public void setTypeOfDelivery(String typeOfDelivery) {
        TypeOfDelivery = typeOfDelivery;
    }

    public String getAddressForCourier() {
        return addressForCourier;
    }

    public void setAddressForCourier(String addressForCourier) {
        this.addressForCourier = addressForCourier;
    }

    public String getTypeOfPayment() {
        return TypeOfPayment;
    }

    public void setTypeOfPayment(String typeOfPayment) {
        TypeOfPayment = typeOfPayment;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", TypeOfDelivery='" + TypeOfDelivery + '\'' +
                ", addressForCourier='" + addressForCourier + '\'' +
                ", TypeOfPayment='" + TypeOfPayment + '\'' +
                ", fullPrice='" + fullPrice + '\'' +
                ", account=" + account +
                ", products=" + products +
                '}';
    }
}
