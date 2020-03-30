package val.project.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
public class ProductDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    private String soleMaterial;
    private String soleHeight;
    private String sex;
    private String season;

    @OneToMany (mappedBy = "productDescription",cascade = CascadeType.DETACH)
    @JsonBackReference
    private List<Product> product;

    public ProductDescription() {
    }

    public ProductDescription(String soleMaterial, String soleHeight, String sex, String season) {
        this.soleMaterial = soleMaterial;
        this.soleHeight = soleHeight;
        this.sex = sex;
        this.season = season;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSoleMaterial() {
        return soleMaterial;
    }

    public void setSoleMaterial(String soleMaterial) {
        this.soleMaterial = soleMaterial;
    }

    public String getSoleHeight() {
        return soleHeight;
    }

    public void setSoleHeight(String soleHeight) {
        this.soleHeight = soleHeight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }


}
