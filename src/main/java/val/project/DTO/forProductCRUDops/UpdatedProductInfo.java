package val.project.DTO.forProductCRUDops;
import com.fasterxml.jackson.annotation.JsonProperty;
import val.project.entities.ProductDescription;
import java.util.List;

public class UpdatedProductInfo {

    private long id;
    private String name;
    private int cost;
    @JsonProperty("brands")
    private BrandInfoFromAdmin brand;
    private List<ProductSizeFromAdmin> productSizes;
    private String vendorCode;
    private int similaritiesIndex;
    private ProductDescriptionFromAdmin productDescription;
    private long productCategories;

    public UpdatedProductInfo(String name, int cost, BrandInfoFromAdmin brand, List<ProductSizeFromAdmin> productSizes, String vendorCode, int similaritiesIndex, ProductDescriptionFromAdmin productDescription, long productCategories) {
        this.name = name;
        this.cost = cost;
        this.brand = brand;
        this.productSizes = productSizes;
        this.vendorCode = vendorCode;
        this.similaritiesIndex = similaritiesIndex;
        this.productDescription = productDescription;
        this.productCategories = productCategories;
    }

    public BrandInfoFromAdmin getBrand() {
        return brand;
    }

    public void setBrand(BrandInfoFromAdmin brand) {
        this.brand = brand;
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

    public List<ProductSizeFromAdmin> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSizeFromAdmin> productSizes) {
        this.productSizes = productSizes;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public int getSimilaritiesIndex() {
        return similaritiesIndex;
    }

    public void setSimilaritiesIndex(int similaritiesIndex) {
        this.similaritiesIndex = similaritiesIndex;
    }

    public ProductDescriptionFromAdmin getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescriptionFromAdmin productDescription) {
        this.productDescription = productDescription;
    }

    public long getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(long productCategories) {
        this.productCategories = productCategories;
    }

    @Override
    public String toString() {
        return "UpdatedProductInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", brand=" + brand +
                ", productSizes=" + productSizes +
                ", vendorCode='" + vendorCode + '\'' +
                ", similaritiesIndex=" + similaritiesIndex +
                ", productDescription=" + productDescription +
                ", productCategories=" + productCategories +
                '}';
    }
}
