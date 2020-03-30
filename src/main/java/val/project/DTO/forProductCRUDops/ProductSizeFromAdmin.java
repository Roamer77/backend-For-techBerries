package val.project.DTO.forProductCRUDops;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductSizeFromAdmin {

    private long id;
    @JsonProperty("sizeValue")
    private Integer size;
    private String location;

    public ProductSizeFromAdmin() {
    }

    public ProductSizeFromAdmin(Integer sizes, String location) {
        this.size = sizes;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ProductSizeFromAdmin{" +
                "sizes=" + size +
                ", location='" + location + '\'' +
                '}';
    }
}
