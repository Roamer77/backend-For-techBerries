package val.project.DTO;

import java.util.List;

public class OrderInfoFromClient {
    private int price;
    private int paymentType;
    private String address;
    private int deliveryType;
    private List<Long> productsIDs;

    public OrderInfoFromClient() {
    }

    public OrderInfoFromClient(int price, int paymentType, String address, int deliveryType, List<Long> productsIDs) {
        this.price = price;
        this.paymentType = paymentType;
        this.address = address;
        this.deliveryType = deliveryType;
        this.productsIDs = productsIDs;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(int deliveryType) {
        this.deliveryType = deliveryType;
    }

    public List<Long> getProductsIDs() {
        return productsIDs;
    }

    public void setProductsIDs(List<Long> productsIDs) {
        this.productsIDs = productsIDs;
    }

    @Override
    public String toString() {
        return "OrderInfoFromClient{" +
                "price=" + price +
                ", paymentType=" + paymentType +
                ", address='" + address + '\'' +
                ", deliveryType=" + deliveryType +
                ", productsIDs=" + productsIDs +
                '}';
    }
}
