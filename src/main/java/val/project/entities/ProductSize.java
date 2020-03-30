package val.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long Id;

    @Column(name = "SIZE_VALUE")
    private int sizeValue;
    @Column(name = "LOCATION")
    private String location;

    @ManyToOne
    @JsonIgnore
    private Product products;

    public ProductSize() {
    }

    public ProductSize(int sizeValue, String location) {
        this.sizeValue = sizeValue;
        this.location = location;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getSizeValue() {
        return sizeValue;
    }

    public void setSizeValue(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
