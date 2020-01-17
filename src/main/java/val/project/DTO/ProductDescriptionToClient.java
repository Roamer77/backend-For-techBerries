package val.project.DTO;

import val.project.entities.ProductDescription;

public class ProductDescriptionToClient {
    private int  id;
    private String soleMaterial;
    private String  soleHeight;
    private int cost;
    private String sex;
    private String season;

    public ProductDescriptionToClient() {
    }

    public ProductDescriptionToClient(int id, String soleMaterial, String soleHeight, int cost, String sex, String season) {
        this.id = id;
        this.soleMaterial = soleMaterial;
        this.soleHeight = soleHeight;
        this.cost = cost;
        this.sex = sex;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoleMaterial() {
        return soleMaterial;
    }

    public void setSoleMaterial(String soleMaterial) {
        this.soleMaterial = soleMaterial;
    }

    public String getSoleHeight() {
        return soleHeight;
    }

    public void setSoleHeight(String soleHeight) {
        this.soleHeight = soleHeight;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
