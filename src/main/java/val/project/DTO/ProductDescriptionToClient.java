package val.project.DTO;

import val.project.entities.ProductDescription;

public class ProductDescriptionToClient {
   private long productId;
   private ProductDescription productDescription;

    public ProductDescriptionToClient() {
    }

    public ProductDescriptionToClient(int productId, ProductDescription productDescription) {
        this.productId = productId;
        this.productDescription = productDescription;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }
}
