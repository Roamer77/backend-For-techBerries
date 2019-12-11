package val.project.entities.testEntites;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;


@Entity
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private  String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "slavedHuman")
    @JsonBackReference
    private List<Alian> aliansHowSlave;
    public Human() {
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

    public List<Alian> getAliansHowSlave() {
        return aliansHowSlave;
    }

    public void setAliansHowSlave(List<Alian> aliansHowSlave) {
        this.aliansHowSlave = aliansHowSlave;
    }
}
