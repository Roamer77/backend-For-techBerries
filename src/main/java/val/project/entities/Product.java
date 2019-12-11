package val.project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedStoredProcedureQueries(@NamedStoredProcedureQuery(name="changeCostForProduct",procedureName ="CHANGECOSTFORPRODUCT",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "my_id", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "new_Const", type = Integer.class)
        }))
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private  int cost;

    @ManyToOne (optional = false,fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonManagedReference
    private ProductDescription productDescription;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonManagedReference
    private List<Brand> brands=new ArrayList<>();

    private int averageRating;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<ProductSize> productSizes;

    private String vendorCode;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
       @JsonBackReference
    private List<Review> reviews=new ArrayList<>();

    private int similaritiesIndex;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonManagedReference
    private ProductCategories productCategories;

    @JsonIgnore
    @OneToOne(optional = false,cascade = CascadeType.ALL)
    private Images images;

    public Product() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public List<ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getSimilaritiesIndex() {
        return similaritiesIndex;
    }

    public void setSimilaritiesIndex(int similaritiesIndex) {
        this.similaritiesIndex = similaritiesIndex;
    }

    public ProductCategories getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(ProductCategories productCategories) {
        this.productCategories = productCategories;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
