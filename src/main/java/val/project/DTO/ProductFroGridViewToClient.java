package val.project.DTO;

public class ProductFroGridViewToClient {
    private String name;
    private int cost;
    private String image;

    public ProductFroGridViewToClient() {
    }

    public ProductFroGridViewToClient(String name, int cost, String image) {
        this.name = name;
        this.cost = cost;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
