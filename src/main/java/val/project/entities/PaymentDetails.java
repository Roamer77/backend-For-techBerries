package val.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long startTime;
    private long endTime;
    private String status;
    private String userPayPalEmail;
    private String UserName;
    private String userSurname;
    private String merchantId;
    private String payeeEmail;
    private double totalSum;

    public PaymentDetails() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserPayPalEmail() {
        return userPayPalEmail;
    }

    public void setUserPayPalEmail(String userPayPalEmail) {
        this.userPayPalEmail = userPayPalEmail;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPayeeEmail() {
        return payeeEmail;
    }

    public void setPayeeEmail(String payeeEmail) {
        this.payeeEmail = payeeEmail;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", userPayPalEmail='" + userPayPalEmail + '\'' +
                ", UserName='" + UserName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", payeeEmail='" + payeeEmail + '\'' +
                ", totalSum=" + totalSum +
                '}';
    }
}
