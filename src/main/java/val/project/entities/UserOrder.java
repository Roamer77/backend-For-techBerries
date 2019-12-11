package val.project.entities;

import javax.persistence.*;


@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private  String TypeOfDelivery;
    private String addressForCourier;
    private String TypeOfPayment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Accounts account;

    public UserOrder() {
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
}
