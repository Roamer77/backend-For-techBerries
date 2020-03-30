package val.project.DTO.forProductCRUDops;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrandInfoFromAdmin {

    private long id;
    @JsonProperty("name")
    private String name;

    private String brandCountry;

    private String manufactureCountry;

    private String manufactureAddress;

    public BrandInfoFromAdmin() {
    }

    public BrandInfoFromAdmin(long id, String name, String brandCountry, String manufactureCountry, String manufactureAddress) {
        this.id = id;
        this.name = name;
        this.brandCountry = brandCountry;
        this.manufactureCountry = manufactureCountry;
        this.manufactureAddress = manufactureAddress;
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

    @Override
    public String toString() {
        return "BrandInfoFromAdmin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandCountry='" + brandCountry + '\'' +
                ", manufactureCountry='" + manufactureCountry + '\'' +
                ", manufactureAddress='" + manufactureAddress + '\'' +
                '}';
    }
}
