package val.project.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "BRAND_COUNTRY")
    private String brandCountry;
    @Column(name = "Manufacture_Country")
    private String manufactureCountry;
    @Column(name = "Manufacture_Address")
    private String manufactureAddress;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy ="brands")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference
    private List<Product> products=new ArrayList<>();

    public Brand() {
    }

    public Brand(String name, String brandCountry, String manufactureCountry, String manufactureAddress) {
        this.name = name;
        this.brandCountry = brandCountry;
        this.manufactureCountry = manufactureCountry;
        this.manufactureAddress = manufactureAddress;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }

    public String getManufactureCountry() {
        return manufactureCountry;
    }

    public void setManufactureCountry(String manufactureCountry) {
        this.manufactureCountry = manufactureCountry;
    }

    public String getManufactureAddress() {
        return manufactureAddress;
    }

    public void setManufactureAddress(String manufactureAddress) {
        this.manufactureAddress = manufactureAddress;
    }
}
