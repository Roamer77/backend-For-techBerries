package val.project.DTO.forProductCRUDops;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductImagesFromAdmin {
    private String smallImage;
    @JsonProperty("listOfBigImages")
    private List<String> bigImages;

    public ProductImagesFromAdmin() {
    }

    public ProductImagesFromAdmin(String smallImage, List<String> bigImages) {
        this.smallImage = smallImage;
        this.bigImages = bigImages;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public List<String> getBigImages() {
        return bigImages;
    }

    public void setBigImages(List<String> bigImages) {
        this.bigImages = bigImages;
    }

    @Override
    public String toString() {
        return "ProductImagesFromAdmin{" +
                "smallImage='" + smallImage + '\'' +
                ", bigImages=" + bigImages +
                '}';
    }
}
