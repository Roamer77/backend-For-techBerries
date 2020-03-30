package val.project.entities;

import javax.persistence.*;

@Entity
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SMALL_SIZE_IMAGE" ,length = 4000)
    private String smallSizeImage;
    @Column(name = "MIDDLE_SIZE_IMAGE",length = 4000)
    private String middleSizeImage;
    @Column(name = "BIG_SIZE_IMAGE_1",length = 4000)
    private String bigSizeImage1;
    @Column(name = "BIG_SIZE_IMAGE_2",length = 4000)
    private String bigSizeImage2;
    @Column(name = "BIG_SIZE_IMAGE_3",length = 4000)
    private String bigSizeImage3;

    @OneToOne(optional = false,mappedBy = "images")
    private Product product;

    public Images() {
    }

    public Images(String smallSizeImage, String bigSizeImage1, String bigSizeImage2, String bigSizeImage3) {
        this.smallSizeImage = smallSizeImage;
        this.bigSizeImage1 = bigSizeImage1;
        this.bigSizeImage2 = bigSizeImage2;
        this.bigSizeImage3 = bigSizeImage3;
    }

    public Images(String smallSizeImage, String middleSizeImage) {
        this.smallSizeImage = smallSizeImage;
        this.middleSizeImage = middleSizeImage;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSmallSizeImage() {
        return smallSizeImage;
    }

    public void setSmallSizeImage(String smallSizeImage) {
        this.smallSizeImage = smallSizeImage;
    }

    public String getMiddleSizeImage() {
        return middleSizeImage;
    }

    public void setMiddleSizeImage(String middleSizeImage) {
        this.middleSizeImage = middleSizeImage;
    }

    public String getBigSizeImage1() {
        return bigSizeImage1;
    }

    public void setBigSizeImage1(String bigSizeImage1) {
        this.bigSizeImage1 = bigSizeImage1;
    }

    public String getBigSizeImage2() {
        return bigSizeImage2;
    }

    public void setBigSizeImage2(String bigSizeImage2) {
        this.bigSizeImage2 = bigSizeImage2;
    }

    public String getBigSizeImage3() {
        return bigSizeImage3;
    }

    public void setBigSizeImage3(String bigSizeImage3) {
        this.bigSizeImage3 = bigSizeImage3;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
