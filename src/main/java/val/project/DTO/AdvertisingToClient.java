package val.project.DTO;

import val.project.entities.Advertising;


public class AdvertisingToClient  {
    int id;
    String advImage;

    public AdvertisingToClient() {
    }

    public AdvertisingToClient(int  id, String advImage) {
        this.id = id;
        this.advImage = advImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdvImage() {
        return advImage;
    }

    public void setAdvImage(String advImage) {
        this.advImage = advImage;
    }

    @Override
    public String toString() {
        return "AdvertisingToClient{" +
                "id=" + id +
                ", advImage='" + advImage + '\'' +
                '}';
    }
}
