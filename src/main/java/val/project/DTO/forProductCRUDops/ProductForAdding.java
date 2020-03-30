package val.project.DTO.forProductCRUDops;

import java.util.List;

public class ProductForAdding {
    private String name;
    private int cost;
    private String vendorCode;
    private int similaritiesIndex;
    private long productCategories;
    private ProductDescriptionFromAdmin productDescription;
    private BrandInfoFromAdmin brand;
    private List<ProductSizeFromAdmin> productSizes;
    private ProductImagesFromAdmin productImages;

    public ProductForAdding() {
    }

    public ProductForAdding(String name, int cost, String vendorCode, int similaritiesIndex, long productCategories, ProductDescriptionFromAdmin productDescription, BrandInfoFromAdmin brand, List<ProductSizeFromAdmin> productSizes, ProductImagesFromAdmin productImages) {
        this.name = name;
        this.cost = cost;
        this.vendorCode = vendorCode;
        this.similaritiesIndex = similaritiesIndex;
        this.productCategories = productCategories;
        this.productDescription = productDescription;
        this.brand = brand;
        this.productSizes = productSizes;
        this.productImages = productImages;
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

    public long getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(long productCategories) {
        this.productCategories = productCategories;
    }

    public ProductDescriptionFromAdmin getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescriptionFromAdmin productDescription) {
        this.productDescription = productDescription;
    }

    public BrandInfoFromAdmin getBrand() {
        return brand;
    }

    public void setBrand(BrandInfoFromAdmin brand) {
        this.brand = brand;
    }

    public List<ProductSizeFromAdmin> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSizeFromAdmin> productSizes) {
        this.productSizes = productSizes;
    }

    public ProductImagesFromAdmin getProductImages() {
        return productImages;
    }

    public void setProductImages(ProductImagesFromAdmin productImages) {
        this.productImages = productImages;
    }

    @Override
    public String toString() {
        return "ProductForAdding{" +
                "name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", similaritiesIndex='" + similaritiesIndex + '\'' +
                ", productCategories='" + productCategories + '\'' +
                ", productDescription=" + productDescription +
                ", brand=" + brand +
                ", productSizes=" + productSizes +
                ", productImages=" + productImages +
                '}';
    }
}
