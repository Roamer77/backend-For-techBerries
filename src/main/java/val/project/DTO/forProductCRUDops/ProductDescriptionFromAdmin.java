package val.project.DTO.forProductCRUDops;

public class ProductDescriptionFromAdmin {
    private String soleMaterial;
    private String soleHeight;
    private String sex;
    private String season;

    public ProductDescriptionFromAdmin(String soleMaterial, String soleHeight, String sex, String season) {
        this.soleMaterial = soleMaterial;
        this.soleHeight = soleHeight;
        this.sex = sex;
        this.season = season;
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

    @Override
    public String toString() {
        return "ProductDescriptionFromAdmin{" +
                "soleMaterial='" + soleMaterial + '\'' +
                ", soleHeight='" + soleHeight + '\'' +
                ", sex='" + sex + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
