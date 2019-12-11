package val.project.entities;

import javax.persistence.*;

@Entity
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(name = "SIZE_VALUE")
    private int sizeValue;
    @Column(name = "LOCATION")
    private String location;


    public ProductSize() {
    }

    public ProductSize(int sizeValue, String location) {
        this.sizeValue = sizeValue;
        this.location = location;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getSizeValue() {
        return sizeValue;
    }

    public void setSizeValue(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
